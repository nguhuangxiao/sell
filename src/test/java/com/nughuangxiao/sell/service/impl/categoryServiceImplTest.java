package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class categoryServiceImplTest {

    @Autowired CategoryServiceImpl categoryService;

    @Test
    public void findById() throws Exception{

        ProductCategory productCategory = categoryService.findById(1);

        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws  Exception{

        List<ProductCategory> productCategory = categoryService.findAll();

        Assert.assertNotEquals(0, productCategory.size());
    }

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategory = categoryService.findByCategoryTypeIn(Arrays.asList(2,3,10));

        Assert.assertNotEquals(0, productCategory);
    }

    @Test
    public void save() {

        ProductCategory productCategory = new ProductCategory("德玛西亚",6);
        ProductCategory result = categoryService.save(productCategory);

    }
}