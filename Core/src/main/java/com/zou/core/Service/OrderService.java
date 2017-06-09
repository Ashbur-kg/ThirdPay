package com.zou.core.Service;

import com.zou.core.Dao.OrderDao;
import com.zou.core.Vo.Order;
import com.zou.domain.OrderPojo;
import com.zou.domain.RequestPayResult;
import com.zou.domain.ResponsePayResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/6/2.
 */
@org.springframework.stereotype.Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public Order getOrder(){
        Integer id = 290;
        Order order = orderDao.getOrder(id);
        return order;
    }

    public ResponsePayResult getPayResult(Long id) {
        ResponsePayResult payResult = orderDao.getPayResult(id);
        return payResult;
    }


    public ResponsePayResult getPayPostResult(RequestPayResult requestPayResult) {
        return orderDao.getPayPostResult(requestPayResult);
    }

    public OrderPojo getOrderPojo(Long id) {
        return orderDao.getOrderPojo(id);
    }

}
