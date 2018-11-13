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

    /** 库存 **/
    private Integer productStock;

    /** 描述 **/
    private String productDescription;

    /** 小图 **/
    private String productIcon;

    /** 类目编号 **/
    private Integer categoryType;

    /** 类目状态 **/
    private Integer productStatus;

    public ProductInfo(String productId, String productName, Integer productStock, String productDescription, String productIcon, Integer categoryType, Integer productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.categoryType = categoryType;
        this.productStatus = productStatus;
    }
}
