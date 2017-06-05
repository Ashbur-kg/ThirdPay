package com.zou.comsumer.feign;

import com.zou.domain.ResponsePayResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/5.
 */
@FeignClient(name = "core")
public interface PayResultFeignPost {
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public ResponsePayResult getPayResult(@PathVariable("id") Integer id);
}
