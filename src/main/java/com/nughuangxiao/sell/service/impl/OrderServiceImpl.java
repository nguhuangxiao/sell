package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.OrderDetail;
import com.nughuangxiao.sell.dataobj.OrderMaster;
import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.dataobj.SellerInfo;
import com.nughuangxiao.sell.dto.CartDto;
import com.nughuangxiao.sell.dto.OrderDto;
import com.nughuangxiao.sell.repository.OrderDetailRepository;
import com.nughuangxiao.sell.repository.OrderMasterRepository;
import com.nughuangxiao.sell.service.OrderService;
import com.nughuangxiao.sell.service.ProductService;
import com.nughuangxiao.sell.service.SellerInfoService;
import com.nughuangxiao.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerInfoService sellerInfoService;

    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) {

        String orderId = KeyUtil.genUniqueKey(); //订单ID

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO); //0

        SellerInfo sellerInfo = sellerInfoService.findOne(orderDto.getSellId());

        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {

            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            //计算总价
            orderAmount = productInfo.getProductPrice()
                .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                .add(orderAmount);

            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);

            BeanUtils.copyProperties(productInfo, orderDetail);

            orderDetailRepository.save(orderDetail); //保存到order_detail表

        }

        //总价加上额外费用
        orderAmount = orderAmount.add(sellerInfo.getDeliveryPrice()).add(sellerInfo.getPackingPrice());

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerName(orderDto.getBuyerName());
        orderMaster.setBuyerPhone(orderDto.getBuyerPhone());
        orderMaster.setBuyerAddress(orderDto.getBuyerAddress());
        orderMaster.setBuyerOpenid(orderDto.getBuyerOpenid());
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);

        orderMasterRepository.save(orderMaster);

        //扣库存
        /*
        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream().map(e ->
            new CartDto(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        */

        List<CartDto> cartDtoList = new ArrayList<>();
               for(int i=0; i<orderDto.getOrderDetailList().size(); i++) {
            OrderDetail orderDetail = orderDto.getOrderDetailList().get(i);
            CartDto cartDto = new CartDto();
            cartDto.setProductId(orderDetail.getProductId());
            cartDto.setProductQuantity((orderDetail.getProductQuantity()));
            cartDtoList.add(cartDto);
        }

        productService.decreaseStock(cartDtoList);

        orderDto.setOrderAmount(orderAmount);
        orderDto.setOrderStatus(0);
        orderDto.setPayStatus(0);

        return orderDto;
    }

    @Override
    public OrderDto findById(String orderId) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        //查看订单状态-已完结的订单不允许取消

        //修改订单状态

        //返回库存

        //已支付的，退钱
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
