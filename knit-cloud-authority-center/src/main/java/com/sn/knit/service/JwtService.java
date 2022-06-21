package com.sn.knit.service;


import com.sn.knit.vo.UsernameAndPassword;

/**
 * JWT 相关服务接口定义
 *
 * @author Administrator
 * @date 2022/06/19
 */
public interface JwtService {

    /**
     * 生成 JWT Token, 使用默认的超时时间
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link String}
     * @throws Exception 异常
     */
    String generateToken(String username, String password) throws Exception;

    /**
     * 生成指定超时时间的 Token, 单位是天
     *
     * @param username 用户名
     * @param password 密码
     * @param expire 失效
     * @return {@link String}
     * @throws Exception 异常
     */
    String generateToken(String username, String password, int expire) throws Exception;

    /**
     * 注册用户并生成 Token 返回
     *
     * @param usernameAndPassword 用户名和密码
     * @return {@link String}
     * @throws Exception 异常
     */
    String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword)
            throws Exception;
}
