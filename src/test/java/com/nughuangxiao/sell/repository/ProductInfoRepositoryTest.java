package com.nughuangxiao.sell.repository;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {

        ProductInfo productInfo = new ProductInfo(
            "1",
            "皮蛋粥",
            2.2,
            100,
            "大众热销",
            "http://baodu.com",
            1,
            2
        );

        repository.save(productInfo);

    }

}