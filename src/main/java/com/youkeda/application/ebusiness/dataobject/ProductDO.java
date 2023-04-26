package com.youkeda.application.ebusiness.dataobject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.youkeda.application.ebusiness.model.Category;
import com.youkeda.application.ebusiness.model.ImageResource;
import com.youkeda.application.ebusiness.model.Product;
import com.youkeda.application.ebusiness.model.ProductStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 */
public class ProductDO {

    private long id;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;
    // 发布人
    private long userId;
    // 商品名称
    private String name;
    // 商品描述
    private String description;
    // 商品图片，JSON格式图片列表
    private String images;
    // 商品详情，多个图片地址。JSON格式图片列表
    private String detail;
    // 商品状态
    private String status;
    // 商品类目，一个商品可以有多个类目。JSON格式类目 id 列表
    private String categoryIds;
    // 商品参考价格
    private Double price;
    // 库存
    private Integer stock;

    public ProductDO () {

    }

    public ProductDO(Product product){
//        this.id = product.getId();
        if (product.getUser() != null) {
            this.userId = product.getUser().getId();
        }
        this.name = product.getName();
        this.description = product.getDescription();
        if (!CollectionUtils.isEmpty(product.getImages())) {
            this.images = JSON.toJSONString(product.getImages());
        }
        if (!CollectionUtils.isEmpty(product.getDetail())) {
            this.detail = JSON.toJSONString(product.getDetail());
        }
        this.status = product.getStatus().name();
        if (!CollectionUtils.isEmpty(product.getCategories())) {
            List<Long> categoryIds = new ArrayList<>();
            for (Category category : product.getCategories()){
                categoryIds.add(category.getId());
            }
            this.categoryIds = JSON.toJSONString(categoryIds);
        }
        this.price = product.getPrice();
        this.stock = product.getStock();
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
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
