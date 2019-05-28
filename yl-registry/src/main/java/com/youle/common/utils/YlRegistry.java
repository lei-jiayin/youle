package com.youle.common.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author xw
 * @date 2019/5/28 15:16
 */
@SpringBootApplication
@EnableEurekaServer
public class YlRegistry {
    //psvm
    public static void main(String[] args) {
        SpringApplication.run(YlRegistry.class);
    }
}
