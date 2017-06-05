package com.zou.comsumer.feign;

import com.zou.config.FeignLogConfiguration;
import com.zou.domain.ResponsePayResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/5.
 * 使用feign的日志功能
 */
@FeignClient(name = "core",configuration = FeignLogConfiguration.class)
public interface PayResultFeignLog {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponsePayResult getPayResult(@PathVariable("id") Integer id);
}
