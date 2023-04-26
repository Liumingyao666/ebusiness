package com.youkeda.application.ebusiness.service.impl;

import com.youkeda.application.ebusiness.dao.CategoryDAO;
import com.youkeda.application.ebusiness.dataobject.CategoryDO;
import com.youkeda.application.ebusiness.model.Category;
import com.youkeda.application.ebusiness.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category add(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDO categoryDO = new CategoryDO(category);
        //返回插入数据的条数
        int r = categoryDAO.insert(categoryDO);
        if (r > 0) {
            return category;
        }
        return null;
    }

    @Override
    public List<Category> queryAll() {
        //查询所有类目
        List<CategoryDO> categoryDOList = categoryDAO.selectAll();

        if (CollectionUtils.isEmpty(categoryDOList)) {
            return null;
        }

        //初始化一个虚拟根节点，0可以对应所有一级类目的父类目
        Map<Long, Category> categoryMap = new HashMap<>();
        categoryMap.put(0L, new Category());

        List<Category> categories = new ArrayList<>();
        //把所有DO转化成model
        categoryDOList.forEach(categoryDO -> {
            Category category = categoryDO.toModel();
            categories.add(category);
            categoryMap.put(category.getId(), category);
        });

        //再次遍历model的list,处理父子关系
        categories.forEach(category -> {
            //得到父实例
            Category parentCategory = categoryMap.get(category.getParentCategoryId());
            if (parentCategory != null) {
                //子列表是否初始化，未，则初始化
                if (parentCategory.getSubCategoryList() == null) {
                    parentCategory.setSubCategoryList(new ArrayList<>());
                }

                //当前model放入父级存放存放子类目的list中
                parentCategory.getSubCategoryList().add(category);
            }
        });

        //返回一级类目
        List<Category> categoryList = categoryMap.get(0L).getSubCategoryList();

        return categoryList;
    }

    @Override
    public Category get(Long id, boolean deepFill) {

        if (id == 0 || id < 0) {
            return null;
        }

        //根据主键查询类目
        CategoryDO categoryDO = categoryDAO.get(id);

        if (categoryDO == null) {
            return null;
        }
        Category category = categoryDO.toModel();
        //填充子类目的model列表
        category = fillSubs(category, deepFill);

        return category;
    }

    /**
     *
     * @param category 需要填充子类目的当前类目
     * @param deepFill 多层级填充， true：填充所有子类目， false：只填充一级
     * @return
     */
    private Category fillSubs(Category category, boolean deepFill){
        if (category == null || category.getId() < 0) {
            return null;
        }

        //调用DAO方法，查询当前类目的所有子类目
        List<CategoryDO> categoryDOS = categoryDAO.selectByParentId(category.getId());

        //如果没有子类目了，返回自身，没有填充
        if (CollectionUtils.isEmpty(categoryDOS)) {
            return category;
        }

        List<Category> categories = new ArrayList<>();
        //遍历所有子类目，把子类目的model实例add到子类目的list中，如果要填充所有，递归调用此方法
        for(CategoryDO categoryDO : categoryDOS){
            Category category1 = categoryDO.toModel();
            categories.add(category1);
            //做数据验证
            if (deepFill) {
                category1 = fillSubs(category1, deepFill);
            }
        }

        //把子类目的list更新到当前类目的model
        category.setSubCategoryList(categories);
        return category;
    }
}
