package com.zou.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/6/4.
 */
public class ResponsePayResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String orderNo;
    private String declNo;
    private BigDecimal denoteAmt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDeclNo() {
        return declNo;
    }

    public void setDeclNo(String declNo) {
        this.declNo = declNo;
    }

    public BigDecimal getDenoteAmt() {
        return denoteAmt;
    }

    public void setDenoteAmt(BigDecimal denoteAmt) {

        this.denoteAmt = denoteAmt;
    }

    @Override
    public String toString() {
        return "ResponsePayResult{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", declNo='" + declNo + '\'' +
                ", denoteAmt=" + denoteAmt +
                '}';
    }
}
