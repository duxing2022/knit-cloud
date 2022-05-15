package com.sn.knit.service;

import com.sn.knit.domain.User;
import com.sn.knit.vo.CommonResponse;

/**
 * @author lenovo
 */
public interface LoginService {

    /**
     * 登入
     *
     * @param user user
     * @return CommonResponse
     */
    CommonResponse<?> login(User user);

    /**
     * 登出
     *
     * @return CommonResponse
     */
    CommonResponse<?> logout();

}
