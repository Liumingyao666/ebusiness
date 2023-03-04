package com.youkeda.application.ebusiness.model;

/**
 * @author 刘铭垚
 * @version 1.0
 * 商品图片model类
 */
public class ImageResource {

    //图片名称
    private String name;

    //图片URL
    private String url;

    //图片描述
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
