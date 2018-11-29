package com.nughuangxiao.sell.service;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {


    ProductInfo findOne(String productId);

    /**
     * 查询在架所有商品
     */
    List<ProductInfo> findUpAll();


    Page<ProductInfo> findAll(Pageable pageable);


    ProductInfo save(ProductInfo productInfo);

    //加库存
    void addStock(List<CartDto> cartDtoList);

    //减库存
    void decreaseStock(List<CartDto> cartDtoList);

}
