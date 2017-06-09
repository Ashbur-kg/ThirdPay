package com.zou.comsumer.feign;

import com.zou.domain.OrderPojo;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/5.
 */
@FeignClient(name = "core", fallbackFactory = OrderFeignFallbackFactory.class)

public interface OrderFeignClientFallbackFactory {
    @GetMapping("/getOrderById/{id}")
    public OrderPojo getOrderById(@PathVariable("id") Long id);
}

@Component
//fallbackFactory属性还有很多其他的用途，例如让不同的异常返回不同的回退结果
class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignClientFallbackFactory> {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderFeignFallbackFactory.class);
    @Override
    public OrderFeignClientFallbackFactory create(Throwable throwable) {

        return new OrderFeignClientFallbackFactory(){

            @Override
            public OrderPojo getOrderById(@PathVariable("id") Long id) {
                //重写getOrderById，添加日志信息
                // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
                // 否则在引用启动时，就会打印该日志。
                // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
                //打印异常信息
                LOGGER.info("fallback; reason was:", throwable);
                OrderPojo order = new OrderPojo();
                order.setId(1L);
                order.setUpdateTime(new Date());
                order.setCreateTime(new Date());
                return order;
            }
        };
    }
}