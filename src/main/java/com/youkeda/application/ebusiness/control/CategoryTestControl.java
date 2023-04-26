package com.youkeda.application.ebusiness.control;

import com.youkeda.application.ebusiness.model.Category;
import com.youkeda.application.ebusiness.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘铭垚
 * @version 1.0
 * 类目自测
 */

@Controller
public class CategoryTestControl {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/test/category")
    @ResponseBody
    public Map testCategory () {
        Map result = new HashMap();

        List<Category> categories = categoryService.queryAll();
        result.put("categories", categories);

        Category category = categoryService.get(1L, true);
        result.put("category", category);

        Category category1 = categoryService.get(1L, false);
        result.put("category1",category1);

        return result;
    }



}
