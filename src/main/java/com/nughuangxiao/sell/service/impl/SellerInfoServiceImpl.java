package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.SellerInfo;
import com.nughuangxiao.sell.repository.SellerInfoRepository;
import com.nughuangxiao.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

  @Autowired
  private SellerInfoRepository repository;

  @Override
  public SellerInfo findOne(Integer sellId) {
    return repository.findById(sellId).get();
  }

  @Override
  public SellerInfo save(SellerInfo sellerInfo) {
    return repository.save(sellerInfo);
  }
}
