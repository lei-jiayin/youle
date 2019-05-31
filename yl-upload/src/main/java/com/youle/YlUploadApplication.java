package com.youle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xw
 * @date 2019/5/31 14:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class YlUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlUploadApplication.class);
    }
}
