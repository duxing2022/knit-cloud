package com.sn.knit.filter.factory;

import com.sn.knit.filter.HeaderTokenGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * 请求头部携带 Token 验证过滤器工厂
 *
 * @author Administrator
 * @date 2022/06/26
 */
@Component
public class HeaderTokenGatewayFilterFactory
        extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return new HeaderTokenGatewayFilter();
    }
}
