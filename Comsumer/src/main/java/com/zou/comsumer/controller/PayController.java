package com.zou.comsumer.controller;

import com.zou.comsumer.feign.PayResultFeignClient;
import com.zou.comsumer.feign.PayResultFeignCustom;
import com.zou.comsumer.feign.PayResultFeignPost;
import com.zou.domain.RequestPayResult;
import com.zou.domain.ResponsePayResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/6/4.
 */
@RestController
public class PayController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private RestTemplate restTemplate;
    //Ribbon负载均衡
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private PayResultFeignClient feignClient;

    @Autowired
    private PayResultFeignCustom feignClientCustom;
    @Autowired
    private PayResultFeignPost feignPost;

    public String toIndex(){
        return "index";
    }

    @GetMapping("/getPayResult")
    public ResponsePayResult getPayResult(ModelMap modelMap, Integer id) {
        //this.restTemplate.postForObject("http://core/postPayResult", ResponsePayResult.class);
        ResponsePayResult payResult = restTemplate.getForObject("http://core/postPayResult/1", ResponsePayResult
                .class);
        modelMap.put("payResult", payResult);
        return payResult;
    }

    //使用默认的Feign
    @GetMapping("/getPayResultByFeign/{id}")
    public ResponsePayResult getPayResultByFeign(@PathVariable("id") Integer id) {
        ResponsePayResult payResult = feignClient.getPayResult(id);
        System.out.println(payResult);
        return payResult;
    }

    //使用自定义的Feign
    @GetMapping("/getPayResultByFeignCustom/{id}")
    public ResponsePayResult getPayResultByFeignCustom(@PathVariable("id") Integer id) {
        ResponsePayResult payResult = feignClientCustom.getPayResult(id);
        return payResult;
    }

    //Post请求
    @PostMapping("/getPayResultByPost")
    public ResponsePayResult getPayResultByPost(@RequestBody RequestPayResult requestPayResult) {
        ResponsePayResult payResult = feignPost.getPayResult(470);
        return payResult;
    }
}
