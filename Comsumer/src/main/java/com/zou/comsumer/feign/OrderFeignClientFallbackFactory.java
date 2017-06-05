package com.zou.comsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import feign.hystrix.FallbackFactory;
/**
 * Created by Administrator on 2017/6/5.
 */
@FeignClient(name = "core", fallback = OrderFeignFallback.class)

public interface OrderFeignClientFallbackFactory {

}
class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignClientFallbackFactory>{

    @Override
    public OrderFeignClientFallbackFactory create(Throwable throwable) {
        return null;
    }
}