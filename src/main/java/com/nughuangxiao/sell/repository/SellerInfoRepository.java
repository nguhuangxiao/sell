package com.nughuangxiao.sell.repository;

import com.nughuangxiao.sell.dataobj.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo, Integer> {

    /** 查询 **/
    SellerInfo findBySellId(Integer sellId);

}
