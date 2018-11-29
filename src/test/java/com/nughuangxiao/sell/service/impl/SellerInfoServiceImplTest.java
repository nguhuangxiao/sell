package com.nughuangxiao.sell.service.impl;

import com.nughuangxiao.sell.dataobj.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellInfoService;

    @Test
    public void findOne() throws Exception {

      sellInfoService.findOne(1);

  }


  @Test
  public void save() throws Exception {
    SellerInfo sellerInfo = new SellerInfo(
      1,
      "http://static.galileo.xiaojukeji.com/static/tms/seller_avatar_256px.jpg",
      "粥品香坊（回龙观）",
      "粥品香坊其烹饪粥料的秘方源于中国千年古法，在融和现代制作工艺，由世界烹饪大师屈浩先生领衔研发。坚守纯天然、0添加的良心品质深得消费者青睐，发展至今成为粥类的引领品牌。是2008年奥运会和2013年园博会指定餐饮服务商。",
      "蜂鸟专送",
      new BigDecimal(4.3),
      new BigDecimal(4),
      new BigDecimal(2),
      new BigDecimal(20),
      38
    );
    sellInfoService.save(sellerInfo);
  }


}
