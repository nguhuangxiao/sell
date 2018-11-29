package com.nughuangxiao.sell.dataobj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class SellerInfo {

    @Id
    /** 卖家id **/
    private Integer sellId;

    /** 图片 **/
    private String sellIcon;

    /** 卖家名称 **/
    private String sellName;

    /** 公告 **/
    private String sellNotice;

    /** 描述 **/
    private String sellDescription;

    /** 服务评价 **/
    private BigDecimal sellScore;

    /** 配送费 **/
    private BigDecimal deliveryPrice;

    /** 包装费 **/
    private BigDecimal packingPrice;

    /** 最低费用 **/
    private BigDecimal minPrice;

    /** 送达时间 **/
    private Integer deliveryTime;

    public SellerInfo(Integer sellId, String sellIcon, String sellName, String sellNotice, String sellDescription, BigDecimal sellScore, BigDecimal deliveryPrice, BigDecimal packingPrice, BigDecimal minPrice, Integer deliveryTime) {
        this.sellId = sellId;
        this.sellIcon = sellIcon;
        this.sellName = sellName;
        this.sellNotice = sellNotice;
        this.sellDescription = sellDescription;
        this.sellScore = sellScore;
        this.deliveryPrice = deliveryPrice;
        this.packingPrice = packingPrice;
        this.minPrice = minPrice;
        this.deliveryTime = deliveryTime;
    }
}
