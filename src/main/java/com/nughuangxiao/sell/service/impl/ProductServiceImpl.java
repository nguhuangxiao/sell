package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.dto.CartDto;
import com.nughuangxiao.sell.enums.ProductStatusEnum;
import com.nughuangxiao.sell.enums.ResultEnum;
import com.nughuangxiao.sell.exception.FailRequestException;
import com.nughuangxiao.sell.repository.ProductInfoRepository;
import com.nughuangxiao.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void addStock(List<CartDto> cartDtoList) {
        for(CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = productService.findOne(cartDto.getProductId());

            if(productInfo == null) {
                throw new FailRequestException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDto.getProductQuantity();

            if(result < 0) {
                throw new FailRequestException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for(CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = productService.findOne(cartDto.getProductId());

            if(productInfo == null) {
                throw new FailRequestException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();

            if(result < 0) {
                throw new FailRequestException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }
}
