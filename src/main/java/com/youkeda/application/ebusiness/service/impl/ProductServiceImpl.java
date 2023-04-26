package com.youkeda.application.ebusiness.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.youkeda.application.ebusiness.dao.CategoryDAO;
import com.youkeda.application.ebusiness.dao.ProductDAO;
import com.youkeda.application.ebusiness.dao.UserDAO;
import com.youkeda.application.ebusiness.dataobject.CategoryDO;
import com.youkeda.application.ebusiness.dataobject.ProductDO;
import com.youkeda.application.ebusiness.dataobject.UserDO;
import com.youkeda.application.ebusiness.model.*;
import com.youkeda.application.ebusiness.param.BasePageParam;
import com.youkeda.application.ebusiness.service.CategoryService;
import com.youkeda.application.ebusiness.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务实现类
 * @author 刘铭垚
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Product save(Product product) {
        if (product == null) {
            return null;
        }

        ProductDO productDO = new ProductDO(product);
        int insertSize = productDAO.insert(productDO);
        if (insertSize < 1) {
            return null;
        }

        product.setId(productDO.getId());

        return product;
    }

    @Override
    public Paging<Product> pageQueryProduct(BasePageParam param) {
        //查询指定页和条数的商品
        List<ProductDO> productDOS = productDAO.pageQuery(param);
        //把DO转化成model，放入列表中
        List<Product> resultData = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productDOS)) {
            for (ProductDO productDO : productDOS) {
                Product product = productToModel(productDO);
                resultData.add(product);
            }
        }

        //查询总记录数
        int allCount = productDAO.selectAllCounts();
        //转化成分页对象
        Paging<Product> result = new Paging<>(param.getPagination(), param.getPageSize(), allCount, resultData);
        return result;
    }


    /**
     * DO转model
     * @return
     */
    private Product productToModel (ProductDO productDO) {
        Product product = new Product();
        product.setId(productDO.getId());
//        处理用户
        if (productDO.getUserId() > 0) {
            UserDO userDO = userDAO.findByUserId(productDO.getUserId());
            User user = userDO.toModel();
            product.setUser(user);
        }
        product.setName(productDO.getName());
        product.setDescription(productDO.getDescription());
        if (!StringUtils.isNoneBlank(productDO.getImages())) {
            product.setImages(JSON.parseObject(productDO.getImages(), new TypeReference<List<ImageResource>>(){
            }));
        }
        if (!StringUtils.isNoneBlank(productDO.getDetail())) {
            product.setDetail(JSON.parseObject(productDO.getDetail(), new TypeReference<List<ImageResource>>(){
            }));
        }
        product.setStatus(ProductStatus.valueOf(productDO.getStatus()));
        //处理类目
        if (!StringUtils.isNoneBlank(productDO.getCategoryIds())) {
            List<Category> categories = new ArrayList<>();

            List<Long> ids = JSON.parseObject(productDO.getCategoryIds(), new TypeReference<List<Long>>(){
            });

            for (Long id : ids) {
                CategoryDO categoryDO = categoryDAO.get(id);
                Category category = categoryDO.toModel();
                categories.add(category);
            }
            product.setCategories(categories);
        }

        product.setPrice(productDO.getPrice());
        product.setStock(productDO.getStock());
        return product;
    }
}
