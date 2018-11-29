package com.nughuangxiao.sell.form;

import com.nughuangxiao.sell.dataobj.OrderDetail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderForm {

    /** 卖家Id **/
    private Integer sellId;

    /** 买家姓名 **/
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家电话 **/
    @NotEmpty(message = "电话必填")
    private String phone;

    /** 买家地址 **/
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家openId **/
    @NotEmpty(message = "openId必填")
    private String openId;

    /** 购物车 **/
    @NotEmpty(message = "购物车不能为空")
    private List<OrderDetail> item;

}
