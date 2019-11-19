package com.zuikc.bean;

import java.util.List;

/*
分页查询  数据类  存放分页相关的所有数据
 */
public class CustomerPageBean {

    private int pageNum;//当前页码
    private int pageSize;//每页记录条数
    private int totalCount;//总记录条数
    private int totalPageNum;//总页数
    private List<Customer> customers;//当前页需要的数据

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

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerPageBean() {
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

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerPageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageNum=" + totalPageNum +
                ", customers=" + customers +
                '}';
    }
}
