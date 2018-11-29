package com.nughuangxiao.sell.repository;

import com.nughuangxiao.sell.dataobj.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    OrderMaster findByOrderId(String orderId);

}
