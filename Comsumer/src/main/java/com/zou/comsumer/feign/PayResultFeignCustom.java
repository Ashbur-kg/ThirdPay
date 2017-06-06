package com.zou.comsumer.feign;

import com.zou.config.FeignConfigurationCustom;
import com.zou.domain.ResponsePayResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/5.
 */


/**
 * 使用@FeignClient的configuration属性，指定feign的配置类。
 *
 * @author 周立
 */
@FeignClient(name = "core", configuration = FeignConfigurationCustom.class)
public interface PayResultFeignCustom {
    /**
     * 使用feign自带的注解@RequestLine
     *
     * @param id 用户id
     * @return 用户信息
    //* @see https://github.com/OpenFeign/feign
     */
    //@RequestLine("GET /{id} ")
    //注意：这里是使用@Param，而不是@PathVariable
    @RequestMapping("/{id}")
    public ResponsePayResult getPayResult(@PathVariable("id")/*@Param("id")*/ Integer id);
}
