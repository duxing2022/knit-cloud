package com.sn.knit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 授权中心启动入口
 *
 * @author Administrator
 * @date 2022/06/19
 */

@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class AuthorityCenterApplication {

    public static void main(String[] args) {
        //@EnableJpaAuditing注解 允许 Jpa 自动审计
        SpringApplication.run(AuthorityCenterApplication.class, args);
    }
}
