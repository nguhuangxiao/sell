package com.nughuangxiao.sell.service;

import com.nughuangxiao.sell.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /** 创建订单 **/
    OrderDto create(OrderDto orderDto);

    /** 查询订单 **/
    OrderDto findById(String orderId);

    /** 取消订单 **/
    OrderDto cancel(OrderDto orderDto);

    /** 完成 **/
    OrderDto finish(OrderDto orderDto);

    /** 支付 **/
    OrderDto paid(OrderDto orderDto);

    /** 删除订单 **/
    OrderDto deleteOrder(String orderId);

    /** 查询订单列表 **/
    Page<OrderDto> findList(Pageable pageable);

}
