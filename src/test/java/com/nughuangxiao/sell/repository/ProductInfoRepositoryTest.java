package com.nughuangxiao.sell.repository;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {

        ProductInfo productInfo = new ProductInfo(
                "3",
                "hah",
                new BigDecimal(2.3),
                10,
                "ceshi",
                "http://baidu.com",
                1,
                2
        );

        repository.save(productInfo);

    }

    @Test
    public void findProduct() {

        ProductInfo productInfo = repository.findById("2").get();

        System.out.println(productInfo);

    }

    @Test
    public void findAllProduct() {

        //ProductInfo productInfo = repository.findAll();

    }

    @Test
    public void findByProductStatus() throws Exception{

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);

        Assert.assertNotEquals(0, productInfoList.size());

        System.out.println(productInfoList);

    }






}