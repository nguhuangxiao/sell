package com.nughuangxiao.sell.controller;

import com.nughuangxiao.sell.VO.ResultVO;
import com.nughuangxiao.sell.converter.OrderFormConverterOrderDto;
import com.nughuangxiao.sell.dto.OrderDto;
import com.nughuangxiao.sell.form.OrderForm;
import com.nughuangxiao.sell.service.OrderService;
import com.nughuangxiao.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer/order")
@CrossOrigin(origins = {"http://localhost:8088", "null"})
public class BuyerOrderController {
    /**
     * 创建订单
     * @return
     */

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVO create (@RequestBody OrderForm orderForm) {

        OrderDto orderDto = OrderFormConverterOrderDto.converter(orderForm);

        OrderDto resultOrder = orderService.create(orderDto);


        return ResultVOUtil.success(resultOrder);
    }


}
