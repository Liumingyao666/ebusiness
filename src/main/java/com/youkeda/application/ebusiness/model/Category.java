package com.youkeda.application.ebusiness.model;

import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 * 类目模型
 * 设计特点：Category实例的parentCategoryId属性值为null,表示此类目为一级类目
 *         Category实例的subCategoryList属性值为null,表示此类目为叶子类目
 */
public class Category extends BaseID<Long>{

    //类目名称
    private String name;

    //类目描述
    private String description;

    //父类目id
    private Long parentCategoryId;

    //子类目列表
    private List<Category> subCategoryList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
