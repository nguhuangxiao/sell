package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.dto.CartDto;
import com.nughuangxiao.sell.enums.ProductStatusEnum;
import com.nughuangxiao.sell.repository.ProductInfoRepository;
import com.nughuangxiao.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return  repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void addStock(List<CartDto> cartDtoList) {



    }

    @Override
    public void decreaseStock(List<CartDto> cartDtoList) {

        for(CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = productService.findOne(cartDto.getProductId());

            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }
}
