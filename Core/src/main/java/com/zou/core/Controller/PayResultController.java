package com.zou.core.Controller;

import com.zou.core.Service.OrderService;
import com.zou.domain.RequestPayResult;
import com.zou.domain.ResponsePayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/4.
 */
@RestController
public class PayResultController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/postPayResult")
    public ResponsePayResult postPayResult(RequestPayResult requestPayResult){
        return orderService.getPayPostResult(requestPayResult);
    }

    @GetMapping("/{id}")
    //@ResponseBody
    public ResponsePayResult responsePayResult(@PathVariable("id") Long id) {
        System.out.println("hello=========hello");
        ResponsePayResult payResult = orderService.getPayResult(id);
        return payResult;
    }
}
