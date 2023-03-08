package com.youkeda.application.ebusiness.control;

import com.youkeda.application.ebusiness.dao.UserDAO;
import com.youkeda.application.ebusiness.dataobject.UserDO;
import com.youkeda.application.ebusiness.model.*;
import com.youkeda.application.ebusiness.param.BasePageParam;
import com.youkeda.application.ebusiness.service.CategoryService;
import com.youkeda.application.ebusiness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Controller
public class ProductTestControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserDAO userDAO;

    @GetMapping(path = "/product/save")
    @ResponseBody
    public Map save () {
        Map result = new HashMap();

        List<Product> products = new ArrayList<>();

        for (int i = 20; i < 31; i++) {
            Product product = new Product();

            UserDO userDO = userDAO.findByUserId(1);
            User user = userDO.toModel();
            product.setUser(user);

            product.setName("测试商品" + i);
            product.setDescription("测试商品描述" + i);

            List<ImageResource> imageResources = new ArrayList<>();
            ImageResource imageResource = new ImageResource();
            imageResource.setName("图片");
            imageResource.setUrl("www.baidu.com");
            imageResource.setDesc("图片描述");
            imageResources.add(imageResource);

            product.setImages(imageResources);
            product.setDetail(imageResources);

            List<Category> categories = new ArrayList<>();
            Category category = categoryService.get(1L, false);
            categories.add(category);
            product.setCategories(categories);

            product.setStatus(ProductStatus.valueOf("ON"));
            product.setPrice(100.00 + i);
            product.setStock(1000 + i);

            Product product1 = productService.save(product);
            products.add(product1);
        }
        result.put("products", products);
        return result;
    }

    @GetMapping(path = "/test/category/pageQuery")
    @ResponseBody
    public Map pageQuery (@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Map result = new HashMap();

        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPagination(pageNum - 1);
        basePageParam.setPageSize(pageSize);
        Paging<Product> paging = productService.pageQueryProduct(basePageParam);
        result.put("paging", paging);


        return result;
    }
}
