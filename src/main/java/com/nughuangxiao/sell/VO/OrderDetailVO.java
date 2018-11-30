package com.nughuangxiao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailVO {

    @JsonProperty("id")
    private String detailId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("quantity")
    private Integer productQuantity;

    @JsonProperty("icon")
    private String productIcon;

}
