package com.nughuangxiao.sell.converter;


import com.nughuangxiao.sell.dataobj.OrderDetail;
import com.nughuangxiao.sell.dto.OrderDto;
import com.nughuangxiao.sell.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

public class OrderFormConverterOrderDto {

    public static OrderDto converter(OrderForm orderForm) {

        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenId());

        List<OrderDetail> orderDetailList = new ArrayList<>(); //定义数组

        for (OrderDetail orderDetail : orderForm.getItem()) {
            orderDetail.setProductId(orderDetail.getProductId());
            orderDetail.setProductQuantity(orderDetail.getProductQuantity());
            orderDetailList.add(orderDetail);
        }

        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;

    }

}
