package com.zou.core.Vo;
import java.math.BigDecimal;


/**
 * @author Michael.Luo
 * @date 2016年7月6日
 * @Description 订单录入信息
 * @version　1.0 **************************************************************************************
 * Date              Full Name            Task/Defect ID              Reason
 * -------------      ------------        -------------------        ----------------
 * 2016年7月6日               Michael Luo           de_id                 Init Version
 * **************************************************************************************
 */
//@Component
public class Order {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String orderNo;            //订单编号
    private Integer memNo;            //客户编号
    private BigDecimal denoteAmt;    //保函费用
    private String orderType;        //订单类型：0-客户支付，1-客户补单，2-平台回扣
    private String payOrderNo;        //支付订单号
    //private String remark;            //备注信息
    //private String OrderDatetime;
    private String declNo;            //报单编号
    private String paySts;            //支付状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeclNo() {
        return declNo;
    }

    public void setDeclNo(String declNo) {
        this.declNo = declNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public BigDecimal getDenoteAmt() {
        return denoteAmt;
    }

    public void setDenoteAmt(BigDecimal denoteAmt) {
        this.denoteAmt = denoteAmt;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }


    //public String getRemark() {
    //    return remark;
    //}
    //
    //public void setRemark(String remark) {
    //    this.remark = remark;
    //}

    //
    //public String getOrderDatetime() {
    //    return OrderDatetime;
    //}
    //
    //public void setOrderDatetime(String orderDatetime) {
    //    OrderDatetime = orderDatetime;
    //}

    public String getPaySts() {
        return paySts;
    }

    public void setPaySts(String paySts) {
        this.paySts = paySts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", memNo=" + memNo +
                ", denoteAmt=" + denoteAmt +
                ", orderType='" + orderType + '\'' +
                ", payOrderNo='" + payOrderNo + '\'' +
                ", declNo='" + declNo + '\'' +
                ", paySts='" + paySts + '\'' +
                '}';
    }
}
