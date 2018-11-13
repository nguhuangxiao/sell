package com.nughuangxiao.sell.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 **/
    private String productName;

    /** 商品价格 **/
    private Double productPrice;

    /** 商品库存 **/
    private Integer productStock;

    /** 描述 **/
    private String productDescription;

    /** 小图 **/
    private String productIcon;

    /** 商品状态 **/
    private Integer productStatus;

    /** 类目编号 **/
    private Integer categoryType;

    public ProductInfo(String productId, String productName, Double productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
