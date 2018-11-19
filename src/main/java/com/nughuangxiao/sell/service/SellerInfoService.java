package com.nughuangxiao.sell.service;

import com.nughuangxiao.sell.dataobj.SellerInfo;

public interface SellerInfoService {

  /** 查询商家信息 **/
  SellerInfo findOne(Integer sellId);

  /** 保存商家信息 **/
  SellerInfo save(SellerInfo sellerInfo);

}
