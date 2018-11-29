package com.nughuangxiao.sell.dataobj;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@DynamicUpdate
@Entity
public class OrderMaster {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

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

}
