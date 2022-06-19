package com.sn.knit.dao;

import com.sn.knit.entity.KnitUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * KnitUser Dao 接口定义
 *
 * @author Administrator
 * @date 2022/06/19
 */
public interface KnitUserDao extends JpaRepository<KnitUser, Long> {

    /**
     * 根据用户名查询 KnitUser 对象 select * from t_knit_user where username = ?
     *
     * @param username 用户名
     * @return {@link KnitUser}
     */
    KnitUser findByUsername(String username);

    /**
     * 根据用户名和密码查询实体对象
     * <p>
     * select * from t_knit_user where username = ? and password = ?
     *
     * @param username 用户名
     * @param password 暗语
     * @return {@link KnitUser}
     */
    KnitUser findByUsernameAndPassword(String username, String password);
}
