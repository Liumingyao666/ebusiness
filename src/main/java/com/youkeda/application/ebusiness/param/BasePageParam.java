package com.youkeda.application.ebusiness.param;

/**
 * 传递给DAO时的页面参数
 * 起始页（偏移量）：从0开始
 * 每页的记录条数
 * @author 刘铭垚
 * @version 1.0
 */
public class BasePageParam {

    private int pagination = 0;
    private int pageSize = 10;

    public int getPagination() {
        return pagination;
    }

    public void setPagination(int pagination) {
        this.pagination = pagination;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
