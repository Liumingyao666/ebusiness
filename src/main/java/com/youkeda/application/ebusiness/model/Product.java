package com.youkeda.application.ebusiness.model;

import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 * 商品model类
 */
public class Product extends BaseID<Long>{

    //发布人
    private User user;

    //商品名称
    private String name;

    //商品描述
    private String description;

    //商品图片
    private List<ImageResource> images;

    //商品详情，多个图片地址
    private List<ImageResource> detail;

    //商品状态
    private ProductStatus status;

    //商品类目，一个商品可以有多个类目
    private List<Category> categories;

    //商品参考价格
    private Double price;

    //库存
    private Integer stock;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<ImageResource> getImages() {
        return images;
    }

    public void setImages(List<ImageResource> images) {
        this.images = images;
    }

    public List<ImageResource> getDetail() {
        return detail;
    }

    public void setDetail(List<ImageResource> detail) {
        this.detail = detail;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
