package com.youle.common.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xw
 * @date 2019/5/28 16:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class YlItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlItemApplication.class);
    }
}
