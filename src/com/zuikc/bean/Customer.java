package com.zuikc.bean;

import java.sql.Date;

public class Customer {
    private String customer_id;
    private String customer_name;
    private String customer_companyName;
    private Date customer_insertDate;
    private String customer_cellphone;
    private String customer_companyAddress;
    private String customer_companyTel;
    private String customer_companyIntro;
    private String customer_remark;
    private Date customer_recentChangeDate;

    public Customer() {
    }

    public Customer(String customer_id, String customer_name, String customer_companyName, Date customer_insertDate, String customer_cellphone, String customer_companyAddress, String customer_companyTel, String customer_companyIntro, String customer_remark, Date customer_recentChangeDate) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_companyName = customer_companyName;
        this.customer_insertDate = customer_insertDate;
        this.customer_cellphone = customer_cellphone;
        this.customer_companyAddress = customer_companyAddress;
        this.customer_companyTel = customer_companyTel;
        this.customer_companyIntro = customer_companyIntro;
        this.customer_remark = customer_remark;
        this.customer_recentChangeDate = customer_recentChangeDate;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_companyName(String customer_companyName) {
        this.customer_companyName = customer_companyName;
    }

    public void setCustomer_insertDate(Date customer_insertDate) {
        this.customer_insertDate = customer_insertDate;
    }

    public void setCustomer_cellphone(String customer_cellphone) {
        this.customer_cellphone = customer_cellphone;
    }

    public void setCustomer_companyAddress(String customer_companyAddress) {
        this.customer_companyAddress = customer_companyAddress;
    }

    public void setCustomer_companyTel(String customer_companyTel) {
        this.customer_companyTel = customer_companyTel;
    }

    public void setCustomer_companyIntro(String customer_companyIntro) {
        this.customer_companyIntro = customer_companyIntro;
    }

    public void setCustomer_remark(String customer_remark) {
        this.customer_remark = customer_remark;
    }

    public void setCustomer_recentChangeDate(Date customer_recentChangeDate) {
        this.customer_recentChangeDate = customer_recentChangeDate;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_companyName() {
        return customer_companyName;
    }

    public Date getCustomer_insertDate() {
        return customer_insertDate;
    }

    public String getCustomer_cellphone() {
        return customer_cellphone;
    }

    public String getCustomer_companyAddress() {
        return customer_companyAddress;
    }

    public String getCustomer_companyTel() {
        return customer_companyTel;
    }

    public String getCustomer_companyIntro() {
        return customer_companyIntro;
    }

    public String getCustomer_remark() {
        return customer_remark;
    }

    public Date getCustomer_recentChangeDate() {
        return customer_recentChangeDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id='" + customer_id + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_companyName='" + customer_companyName + '\'' +
                ", customer_insertDate=" + customer_insertDate +
                ", customer_cellphone='" + customer_cellphone + '\'' +
                ", customer_companyAddress='" + customer_companyAddress + '\'' +
                ", customer_companyTel='" + customer_companyTel + '\'' +
                ", customer_companyIntro='" + customer_companyIntro + '\'' +
                ", customer_remark='" + customer_remark + '\'' +
                ", customer_recentChangeDate=" + customer_recentChangeDate +
                '}';
    }
}

