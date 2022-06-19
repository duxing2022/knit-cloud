package com.sn.knit.service.impl;

import com.alibaba.fastjson.JSON;
import com.sn.knit.constant.AuthorityConstant;
import com.sn.knit.constant.CommonConstant;
import com.sn.knit.dao.KnitUserDao;
import com.sn.knit.entity.KnitUser;
import com.sn.knit.service.IJWTService;
import com.sn.knit.vo.LoginUserInfo;
import com.sn.knit.vo.UsernameAndPassword;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

/**
 * <h1>JWT 相关服务接口实现</h1>
 *
 * @author Administrator
 * @date 2022/06/19
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class JWTServiceImpl implements IJWTService {

    private final KnitUserDao knitUserDao;

    public JWTServiceImpl(KnitUserDao knitUserDao) {
        this.knitUserDao = knitUserDao;
    }

    @Override
    public String generateToken(String username, String password) throws Exception {

        return generateToken(username, password, 0);
    }

    @Override
    public String generateToken(String username, String password, int expire)
            throws Exception {

        // 首先需要验证用户是否能够通过授权校验, 即输入的用户名和密码能否匹配数据表记录
        KnitUser knitUser = knitUserDao.findByUsernameAndPassword(
                username, password
        );
        if (null == knitUser) {
            log.error("can not find user: [{}], [{}]", username, password);
            return null;
        }

        // Token 中塞入对象, 即 JWT 中存储的信息, 后端拿到这些信息就可以知道是哪个用户在操作
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                knitUser.getId(), knitUser.getUsername()
        );

        if (expire <= 0) {
            expire = AuthorityConstant.DEFAULT_EXPIRE_DAY;
        }

        // 计算超时时间
        ZonedDateTime zdt = LocalDate.now().plus(expire, ChronoUnit.DAYS)
                .atStartOfDay(ZoneId.systemDefault());
        Date expireDate = Date.from(zdt.toInstant());

        return Jwts.builder()
                // jwt payload --> KV
                .claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo))
                // jwt id
                .setId(UUID.randomUUID().toString())
                // jwt 过期时间
                .setExpiration(expireDate)
                // jwt 签名 --> 加密
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword)
            throws Exception {

        // 先去校验用户名是否存在, 如果存在, 不能重复注册
        KnitUser oldUser = knitUserDao.findByUsername(
                usernameAndPassword.getUsername());
        if (null != oldUser) {
            log.error("username is registered: [{}]", oldUser.getUsername());
            return null;
        }

        KnitUser knitUser = new KnitUser();
        knitUser.setUsername(usernameAndPassword.getUsername());
        knitUser.setPassword(usernameAndPassword.getPassword());   // MD5 编码以后
        knitUser.setExtraInfo("{}");

        // 注册一个新用户, 写一条记录到数据表中
        knitUser = knitUserDao.save(knitUser);
        log.info("register user success: [{}], [{}]", knitUser.getUsername(),
                knitUser.getId());

        // 生成 token 并返回
        return generateToken(knitUser.getUsername(), knitUser.getPassword());
    }

    /**
     * 根据本地存储的私钥获取到 PrivateKey 对象
     */
    private PrivateKey getPrivateKey() throws Exception {

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(AuthorityConstant.PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priPKCS8);
    }
}
