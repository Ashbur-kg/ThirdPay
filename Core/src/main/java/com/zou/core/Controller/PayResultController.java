package com.zou.core.Controller;

import com.zou.core.Service.OrderService;
import com.zou.domain.RequestPayResult;
import com.zou.domain.ResponsePayResult;
import org.springframework.beans.factory.annotation.Autowired;
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
        return orderService.getPayResult();
    }
}
