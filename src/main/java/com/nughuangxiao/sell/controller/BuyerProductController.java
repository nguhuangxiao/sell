package com.nughuangxiao.sell.controller;


import com.nughuangxiao.sell.VO.ProductInfoVO;
import com.nughuangxiao.sell.VO.ProductVO;
import com.nughuangxiao.sell.VO.ResultVO;
import com.nughuangxiao.sell.dataobj.ProductCategory;
import com.nughuangxiao.sell.dataobj.ProductInfo;
import com.nughuangxiao.sell.service.CategoryService;
import com.nughuangxiao.sell.service.ProductService;
import com.nughuangxiao.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVO list(@RequestParam("sellId") String sellId) {

        List<ProductInfo> productInfoList = productService.findUpAll(); //查询上架商品

        List<Integer> categoryTypeIdList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
          categoryTypeIdList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeIdList); //查询上架商品下对应的类目


        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {

            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo :  productInfoList) {
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }

            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        return ResultVOUtil.success(productVOList);
    }



}
