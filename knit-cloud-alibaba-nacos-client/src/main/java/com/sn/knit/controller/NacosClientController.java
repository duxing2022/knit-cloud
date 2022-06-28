package com.sn.knit.controller;


import com.sn.knit.config.ProjectConfig;
import com.sn.knit.service.NacosClientService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos client controller
 *
 * @author Administrator
 * @date 2022/06/26
 */
@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    private final NacosClientService nacosClientService;
    private final ProjectConfig projectConfig;

    public NacosClientController(NacosClientService nacosClientService,
            ProjectConfig projectConfig) {
        this.nacosClientService = nacosClientService;
        this.projectConfig = projectConfig;
    }

    /**
     * <h2>根据 service id 获取服务所有的实例信息</h2>
     */
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "knit-cloud-nacos-client") String serviceId) {

        log.info("coming in log nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }

    /**
     * <h2>动态获取 Nacos 中的配置信息</h2>
     */
    @GetMapping("/project-config")
    public ProjectConfig getProjectConfig() {
        return projectConfig;
    }
}
