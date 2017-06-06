package com.zou.zuul;

import com.zou.zuul.filter.Pre.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * zuul会代理所有注册到微服务的网关
 * 该代理使用Ribbon来定位注册在EurekaServer
 * 上的微服务，同时，该代理还整合了Hystrix，
 * 从而实现了容错，所有经过Zuul的请求都会在Hystrix
 * 命令中执行
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	//zuul过滤器
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}

	//zuul聚合微服务
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
