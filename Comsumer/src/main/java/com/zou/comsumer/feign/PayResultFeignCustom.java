package com.zou.comsumer.feign;

import com.zou.config.FeignConfiguration;
import com.zou.domain.ResponsePayResult;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2017/6/5.
 */


/**
 * 使用@FeignClient的configuration属性，指定feign的配置类。
 *
 * @author 周立
 */
@FeignClient(name = "core", configuration = FeignConfiguration.class)
public interface PayResultFeignCustom {
    /**
     * 使用feign自带的注解@RequestLine
     *
     * @param id 用户id
     * @return 用户信息
     * @see https://github.com/OpenFeign/feign
     */
    @RequestLine("GET /{id}")
    public ResponsePayResult getPayResult(@PathVariable("id") Integer id);
}
