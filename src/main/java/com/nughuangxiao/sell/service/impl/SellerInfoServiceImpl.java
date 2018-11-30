package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.SellerInfo;
import com.nughuangxiao.sell.enums.ResultEnum;
import com.nughuangxiao.sell.exception.FailRequestException;
import com.nughuangxiao.sell.repository.SellerInfoRepository;
import com.nughuangxiao.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    @Transactional
    public SellerInfo findOne(Integer sellId) {

        SellerInfo sellerInfo = repository.findById(sellId).get();

        if(sellerInfo == null) {
            throw new FailRequestException(ResultEnum.SELLER_NOT_EXIST);
        }

        return sellerInfo;
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        return repository.save(sellerInfo);
    }
}
