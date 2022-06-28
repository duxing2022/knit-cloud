package com.sn.knit.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 配置登录请求转发规则
 *
 * @author Administrator
 * @date 2022/06/26
 */
@Configuration
public class RouteLocatorConfig {

    /**
     * 使用代码定义路由规则, 在网关层面拦截下登录和注册接口
     * */
    @Bean
    public RouteLocator loginRouteLocator(RouteLocatorBuilder builder) {

        // 手动定义 Gateway 路由规则需要指定 id、path 和 uri
        return builder.routes()
                .route(
                        "knit-cloud-authority",
                        r -> r.path(
                                "/knit/knit-cloud/login",
                                "/knit/knit-cloud/register"
                                ).uri("http://localhost:9001/")
                ).build();
    }
}
