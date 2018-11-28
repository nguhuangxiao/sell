package com.nughuangxiao.sell.dataobj;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@DynamicUpdate
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单id **/
    private String orderId;

    /** 产品id **/
    private String productId;

    /** 产品名称 **/
    private String productName;

    /** 商品价格 **/
    private BigDecimal productPrice;

    /** 商品数量 **/
    private Integer productQuantity;

    /** 商品图标 **/
    private String productIcon;

    public OrderDetail(String detailId, String orderId, String productId, String productName, BigDecimal productPrice, Integer productQuantity, String productIcon) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productIcon = productIcon;
    }
}
