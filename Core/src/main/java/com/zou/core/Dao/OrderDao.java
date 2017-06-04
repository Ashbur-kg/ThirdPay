package com.zou.core.Dao;

import com.zou.core.Vo.Order;


/**
 * Created by Administrator on 2017/6/2.
 */
//@Mapper
public interface OrderDao {
    //@Select("select * from orders where id = #{id}")
    public Order getOrder( Integer id);
}
