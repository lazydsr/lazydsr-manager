package com.lazydsr.manager.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * UserInterceptorConfigBean
 * PROJECT_NAME: lazydsr-application
 * PACKAGE_NAME: com.lazydsr.manager.config.bean
 * Created by Lazy on 2017/12/31 22:33
 * Version: 0.1
 * Info: @TODO:...
 */
@Component
@Data
@ConfigurationProperties(prefix = "interceptor.user")
public class UserInterceptorConfigBean {
    private boolean status;
}
