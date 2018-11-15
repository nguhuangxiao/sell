package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {

        ProductInfo productInfo = productService.findOne("2");
        System.out.println(productInfo);

    }

    @Test
    public void findUpAll() throws Exception{

        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() throws Exception{

        PageRequest request = new PageRequest(0, 10);

        Page<ProductInfo> productInfoList = productService.findAll(request);

        System.out.println(productInfoList.getTotalElements());

    }

    @Test
    public void save() throws Exception{
        ProductInfo productInfo = new ProductInfo(
                "4",
                "huangxiao",
                new BigDecimal(10.5),
                99,
                "很好玩到东西",
                "http://baidu.com",
                1,
                3
        );

        productService.save(productInfo);
    }
}