package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.OrderDetail;
import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.dto.OrderDto;
import com.nughuangxiao.sell.repository.OrderMasterRepository;
import com.nughuangxiao.sell.service.OrderService;
import com.nughuangxiao.sell.service.ProductService;
import com.nughuangxiao.sell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public OrderDto create(OrderDto orderDto) {

        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {

            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            //计算总价
            orderAmount = productInfo.getProductPrice()
                .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                .add(orderAmount);

        }





        return orderDto;
    }

    @Override
    public OrderDto findById(String orderId) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto deleteOrder(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDto> findList(Pageable pageable) {
        return null;
    }
}
