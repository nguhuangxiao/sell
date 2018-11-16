package com.nughuangxiao.sell.VO;

import com.nughuangxiao.sell.dataobj.ProductInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    private String categoryName;

    private Integer categoryType;

    private List<ProductInfoVO> productInfoVOList;

}
