package com.zou.core.Service;

import com.zou.core.Dao.OrderDao;
import com.zou.core.Vo.Order;
import com.zou.core.Vo.ResponsePayResult;
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

    public ResponsePayResult getPayResult() {
        return null;
    }
}
