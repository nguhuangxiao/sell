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
                100,
                "大众点评热销",
                "http://www.baidu.com",
                2,
                1
        );
        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus() {



    }
}