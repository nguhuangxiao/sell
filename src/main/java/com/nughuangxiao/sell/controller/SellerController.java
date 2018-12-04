package com.nughuangxiao.sell.controller;

import com.nughuangxiao.sell.VO.ResultVO;
import com.nughuangxiao.sell.VO.SellerVO;
import com.nughuangxiao.sell.dataobj.SellerInfo;
import com.nughuangxiao.sell.service.SellerInfoService;
import com.nughuangxiao.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sell/seller")
@CrossOrigin(origins = {"http://localhost:8088", "null"})
public class SellerController {

    @Autowired
    private SellerInfoService sellerInfoService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVO list (@RequestParam("sellId") Integer sellId) {

        SellerInfo sellerInfo = sellerInfoService.findOne(sellId);

        SellerVO sellerVO = new SellerVO();
        BeanUtils.copyProperties(sellerInfo, sellerVO);

        return ResultVOUtil.success(sellerVO);
    }

}
