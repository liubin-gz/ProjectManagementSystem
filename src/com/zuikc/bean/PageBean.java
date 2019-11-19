package com.zuikc.bean;

import java.util.List;

/*
分页查询  数据类  存放分页相关的所有数据
 */
public class PageBean<Bean> {

    private int pageNum;//当前页码
    private int pageSize;//每页记录条数
    private int totalCount;//总记录条数
    private int totalPageNum;//总页数
    private List<Bean> beanList;//当前页需要的数据

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize, int totalCount, int totalPageNum, List<Bean> beanList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageNum = totalPageNum;
        this.beanList = beanList;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public void setBeanList(List<Bean> beanList) {
        this.beanList = beanList;
    }

    public List<Bean> getBeanList() {
        return beanList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageNum=" + totalPageNum +
                ", beanList=" + beanList +
                '}';
    }
}
