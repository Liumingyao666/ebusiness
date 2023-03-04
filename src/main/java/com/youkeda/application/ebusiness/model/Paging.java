package com.youkeda.application.ebusiness.model;


import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 * 分页模型
 */
public class Paging<R> {

    //页数
    private int pageNum = 1;

    //每页数量
    private int pageSize = 15;

    //总页数
    private int totalPage;

    //总记录数
    private int totalCount;

    //集合数据
    private List<R> data;

    public Paging() {
    }

    public Paging(int pageNum, int pageSize, int totalCount, List<R> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
        //总页数处理,解决奇数页取整
        this.totalPage = (totalCount + pageSize -1)/pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<R> getData() {
        return data;
    }

    public void setData(List<R> data) {
        this.data = data;
    }
}
