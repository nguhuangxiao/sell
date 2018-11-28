package com.nughuangxiao.sell.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;

    /** 买家名称 **/
    private String buyerName;

    /** 买家电话 **/
    private String buyerPhone;

    /** 买家地址 **/
    private String buyerAddress;

    /** 买家openid **/
    private String buyerOpenid;

    /** 订单总金额 **/
    private BigDecimal orderAmount;

    /** 订单状态 **/
    private Integer orderStatus;

    /** 支付状态 **/
    private Integer payStatus;

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}
