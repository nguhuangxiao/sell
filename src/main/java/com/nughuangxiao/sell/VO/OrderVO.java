package com.nughuangxiao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nughuangxiao.sell.dataobj.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderVO {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("name")
    private String buyerName;

    @JsonProperty("phone")
    private String buyerPhone;

    @JsonProperty("address")
    private String buyerAddress;

    @JsonProperty("amount")
    private BigDecimal orderAmount;

    @JsonProperty("orderStatus")
    private Integer orderStatus;

    @JsonProperty("payStatus")
    private Integer payStatus;

    @JsonProperty("cart")
    List<OrderDetail> orderDetailList;

}
