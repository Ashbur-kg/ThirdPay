package com.zou.core.Controller;

import com.zou.core.Service.OrderService;
import com.zou.core.Vo.Order;
import com.zou.domain.OrderPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/2.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping("/getOrder")
    @ResponseBody
    public Order getOrder(){
        Order order = orderService.getOrder();
        System.out.print(order);
        return order;
    }

    @RequestMapping("/getOrderById/{id}")
    @ResponseBody
    public OrderPojo getOrderById(@PathVariable("id") Long id) {
        OrderPojo orderPojo = orderService.getOrderPojo(id);
        return orderPojo;
    }

    @RequestMapping("/getOrderByIdByFeign/{id}")
    @ResponseBody
    public OrderPojo getOrderByIdByFeign(@PathVariable("id") Long id) {
        OrderPojo orderPojo = orderService.getOrderPojo(id);
        return orderPojo;
    }
}
