package com.nughuangxiao.sell.repository;

import com.nughuangxiao.sell.dataobj.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void  findOneTest() {

        ProductCategory productCategory = repository.findById(1).get();

        System.out.println(productCategory.toString());

    }

    @Test
    public void saveProduct() {

        ProductCategory productCategory = new ProductCategory("女生最嗨", 3);

        repository.save(productCategory);
    }

    @Test
    public void updateProduct() {

        ProductCategory productCategory = repository.findById(5).get();
        productCategory.setCategoryType(66);
        repository.save(productCategory);

    }

    @Test
    public void deleteProduct() {

        repository.deleteById(5);

    }

    @Test
    public void findCategoryList() {

        List<Integer> list = Arrays.asList(2,3,10);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());
    }
}