package com.youle.common.utils.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author xw
 * @date 2019/5/28 15:25
 */
@SpringCloudApplication
@EnableZuulProxy
public class YlGateway {
    public static void main(String[] args) {
        SpringApplication.run(YlGateway.class);
    }
}
