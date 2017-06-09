package com.zou.comsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zou.comsumer.feign.OrderFeignClientFallback;
import com.zou.comsumer.feign.OrderFeignClientFallbackFactory;
import com.zou.domain.OrderPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/5.
 */
@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderFeignClientFallback feignClientFallback;

    @Autowired
    private OrderFeignClientFallbackFactory feignClientFallbackFactory;
    //Ribbon负载均衡
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //使用restTemplate和Hystrix做回退机制
    @HystrixCommand(fallbackMethod = "getByIdFallback")
    @GetMapping("/getOrderById/{id}")
    public OrderPojo getOrderById(@PathVariable Long id){
        OrderPojo orderPojo = restTemplate.getForObject("http://core/getOrderById/" + id, OrderPojo.class);
        return orderPojo;
        //return null;
    }

    public OrderPojo getByIdFallback(Long id){
        OrderPojo order = new OrderPojo();
        order.setId(100L);
        order.setUpdateTime(new Date());
        order.setCreateTime(new Date());
        return order;
    }

    @GetMapping("/getOrderByIdByFeign/{id}")
    public OrderPojo getOrderByIdByFeign(@PathVariable Long id) {
        OrderPojo orderPojo = feignClientFallback.getOrderById(id);
        return orderPojo;
        //return null;
    }

    @GetMapping("/getOrderByIdByFeignFactory/{id}")
    public OrderPojo getOrderByIdByFeignFactory(@PathVariable Long id) {
        OrderPojo orderPojo = feignClientFallbackFactory.getOrderById(id);
        return orderPojo;
        //return null;
    }
}
