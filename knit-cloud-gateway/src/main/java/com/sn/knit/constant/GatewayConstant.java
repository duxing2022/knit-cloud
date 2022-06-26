package com.sn.knit.constant;

/**
 * <h1>网关常量定义</h1>
 *
 * @author Administrator
 * @date 2022/06/26
 */
public class GatewayConstant {

    /**
     * 登录 uri
     */
    public static final String LOGIN_URI = "/knit-cloud/login";

    /**
     * 注册 uri
     */
    public static final String REGISTER_URI = "/knit-cloud/register";

    /**
     * 去授权中心拿到登录 token 的 uri 格式化接口
     */
    public static final String AUTHORITY_CENTER_TOKEN_URL_FORMAT =
            "http://%s:%s/knit-cloud-authority-center/authority/token";

    /**
     * 去授权中心注册并拿到 token 的 uri 格式化接口
     */
    public static final String AUTHORITY_CENTER_REGISTER_URL_FORMAT =
            "http://%s:%s/knit-cloud-authority-center/authority/register";
}
