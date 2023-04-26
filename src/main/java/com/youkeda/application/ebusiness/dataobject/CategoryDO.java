package com.youkeda.application.ebusiness.dataobject;

import com.youkeda.application.ebusiness.model.Category;

import java.time.LocalDateTime;

/**
 * @author 刘铭垚
 * @version 1.0
 * 类目映射数据库
 */
public class CategoryDO {

    private long id;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

    private String name;

    private String description;

    //父类目id
    private Long parentCategoryId;

    public CategoryDO() {

    }

    /**
     * model转DO
     * @param category
     */
    public CategoryDO(Category category){
        if (category.getId() != null){
            this.id = category.getId();
        }
        this.name = category.getName();
        this.description = category.getDescription();
        if (category.getParentCategoryId() != null) {
            this.parentCategoryId = category.getParentCategoryId();
        }
    }

    public Category toModel(){
        Category category = new Category();
        category.setId(this.id);
        category.setGmtCreated(this.gmtCreated);
        category.setGmtModified(this.gmtModified);
        category.setName(this.name);
        category.setDescription(this.description);
        category.setParentCategoryId(this.parentCategoryId);
        return category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

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
}
