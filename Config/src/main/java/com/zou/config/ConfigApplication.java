package com.zou.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
/**
 * config使用远程仓库github动态更换配置，
 * 访问以下地址可以得到配置信息：
 * http://localhost:8084/microservice-foo/dev
 * http://localhost:8084/microservice-foo-dev.properties
 * http://localhost:8084/master/microservice-foo-dev.properties
 * http://localhost:8084/config-lable-v2.0/microservice-foo-dev.properties
 *
 */
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
