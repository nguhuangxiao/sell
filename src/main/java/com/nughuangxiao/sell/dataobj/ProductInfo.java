package com.nughuangxiao.sell.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 **/
    private String productName;

    /** 商品价格 **/
    private BigDecimal productPrice;

    /** 商品库存 **/

    private Integer productStock;

    /** 描述 **/
    private String productDescription;

    /** 小图 **/
    private String productIcon;

    /** 类目编号 **/
    private Integer categoryType;

    /** 类目状态 **/
    private Integer productStatus;


    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
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
