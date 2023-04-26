package com.youkeda.application.ebusiness.service;

import com.youkeda.application.ebusiness.model.Category;

import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 * 类目服务
 */
public interface CategoryService {

    /**
     * 新增类目
     * @param category
     * @return
     */
    Category add (Category category);

    /**
     * 取得所有类目
     * @return
     */
    List<Category> queryAll();

    /**
     * 根据主键取得类目
     * @param id
     * @param deepFill :是否需要深度填充子类目 true:深度填充所有子类目的子类目 false:只查当前类目,填充一次
     * @return
     */
    Category get(Long id, boolean deepFill);
}
