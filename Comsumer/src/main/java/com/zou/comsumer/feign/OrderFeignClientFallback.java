package com.zou.comsumer.feign;

import com.zou.domain.OrderPojo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/5.
 * Fiegn的回退机制
 * fallback指定回退类
 */

@FeignClient(name = "core",fallback = OrderFeignFallback.class)
public interface OrderFeignClientFallback {
    @RequestMapping("/getOrderById/{id}")
    public OrderPojo getOrderById(@PathVariable("id") Long id);
}

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 *
 */
@Component
class OrderFeignFallback implements OrderFeignClientFallback {
    @Override
    public OrderPojo getOrderById(@PathVariable("id") Long id) {
        OrderPojo order = new OrderPojo();
        order.setId(1L);
        order.setUpdateTime(new Date());
        order.setCreateTime(new Date());
        return order;
    }
}
