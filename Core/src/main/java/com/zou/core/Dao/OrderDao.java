package com.zou.core.Dao;

import com.zou.core.Vo.Order;
import com.zou.domain.OrderPojo;
import com.zou.domain.RequestPayResult;
import com.zou.domain.ResponsePayResult;


/**
 * Created by Administrator on 2017/6/2.
 */
//@Mapper
public interface OrderDao {
    //@Select("select * from orders where id = #{id}")
    public Order getOrder( Integer id);

    ResponsePayResult getPayResult(Long id);

    public ResponsePayResult getPayPostResult(RequestPayResult requestPayResult);

    public OrderPojo getOrderPojo(Long id);
}
