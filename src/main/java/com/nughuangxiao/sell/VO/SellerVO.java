package com.nughuangxiao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SellerVO {

  @JsonProperty("id")
  private Integer sellId;

  /** 图片 **/
  @JsonProperty("avatar")
  private String sellIcon;

  /** 卖家名称 **/
  @JsonProperty("name")
  private String sellName;

  /** 公告 **/
  @JsonProperty("bulletin")
  private String sellNotice;

  /** 描述 **/
  @JsonProperty("description")
  private String sellDescription;

  /** 服务评价 **/
  @JsonProperty("foodScore")
  private BigDecimal sellScore;

  /** 配送费 **/
  @JsonProperty("deliveryPrice")
  private BigDecimal deliveryPrice;

  /** 最低费用 **/
  @JsonProperty("minPrice")
  private BigDecimal minPrice;

  /** 送达时间 **/
  @JsonProperty("deliveryTime")
  private Integer deliveryTime;


}
