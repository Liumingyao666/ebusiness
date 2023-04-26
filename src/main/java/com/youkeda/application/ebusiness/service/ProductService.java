package com.youkeda.application.ebusiness.service;

import com.youkeda.application.ebusiness.model.Paging;
import com.youkeda.application.ebusiness.model.Product;
import com.youkeda.application.ebusiness.param.BasePageParam;

/**
 * @author 刘铭垚
 * @version 1.0
 */
public interface ProductService {

    /**
     * 增加或修改商品
     * @param product
     * @return
     */
    Product save (Product product);

    /**
     * 分页查询商品
     * @param param
     * @return
     */
    Paging<Product> pageQueryProduct (BasePageParam param);
}
