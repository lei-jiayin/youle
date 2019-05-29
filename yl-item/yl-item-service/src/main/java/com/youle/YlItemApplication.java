package com.youle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xw
 * @date 2019/5/28 16:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.youle.*")
public class YlItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlItemApplication.class);
    }
}
