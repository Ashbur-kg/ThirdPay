package com.zou.comsumer.feign;

import com.zou.domain.ResponsePayResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "core")
/**
 * 使用@FeignClient的configuration属性，指定feign的配置类。
 */
public interface PayResultFeignClient {
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponsePayResult getPayResult(@PathVariable("id") Integer id);

}
