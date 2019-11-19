package com.zuikc.bean;

import java.sql.Date;

public class User {
    private String user_id;
    private String user_name;
    private String user_job;
    private String user_sex;
    private int user_age;
    private String user_cellphone;
    private Date user_insertDate;
    private String user_status;
    private String user_idCard;
    private String user_remark;
    private Date user_recentChangeDate;
    private String user_password;
    private String user_roleId;
    private Date user_entryTime;

    public User() {
    }

    public User(String user_id, String user_name, String user_job, String user_sex, int user_age, String user_cellphone, Date user_insertDate, String user_status, String user_idCard, String user_remark, Date user_recentChangeDate, String user_password, String user_roleId, Date user_entryTime) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_job = user_job;
        this.user_sex = user_sex;
        this.user_age = user_age;
        this.user_cellphone = user_cellphone;
        this.user_insertDate = user_insertDate;
        this.user_status = user_status;
        this.user_idCard = user_idCard;
        this.user_remark = user_remark;
        this.user_recentChangeDate = user_recentChangeDate;
        this.user_password = user_password;
        this.user_roleId = user_roleId;
        this.user_entryTime = user_entryTime;
    }

    public void setUser_entryTime(Date user_entryTime) {
        this.user_entryTime = user_entryTime;
    }

    public Date getUser_entryTime() {
        return user_entryTime;
    }

    public void setUser_roleId(String user_roleId) {
        this.user_roleId = user_roleId;
    }

    public String getUser_roleId() {
        return user_roleId;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_job(String user_job) {
        this.user_job = user_job;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public void setUser_cellphone(String user_cellphone) {
        this.user_cellphone = user_cellphone;
    }

    public void setUser_insertDate(Date user_insertDate) {
        this.user_insertDate = user_insertDate;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public void setUser_idCard(String user_idCard) {
        this.user_idCard = user_idCard;
    }

    public void setUser_remark(String user_remark) {
        this.user_remark = user_remark;
    }

    public void setUser_recentChangeDate(Date user_recentChangeDate) {
        this.user_recentChangeDate = user_recentChangeDate;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_job() {
        return user_job;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public String getUser_cellphone() {
        return user_cellphone;
    }

    public Date getUser_insertDate() {
        return user_insertDate;
    }

    public String getUser_status() {
        return user_status;
    }

    public String getUser_idCard() {
        return user_idCard;
    }

    public String getUser_remark() {
        return user_remark;
    }

    public Date getUser_recentChangeDate() {
        return user_recentChangeDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_job='" + user_job + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_age=" + user_age +
                ", user_cellphone='" + user_cellphone + '\'' +
                ", user_insertDate=" + user_insertDate +
                ", user_status='" + user_status + '\'' +
                ", user_idCard='" + user_idCard + '\'' +
                ", user_remark='" + user_remark + '\'' +
                ", user_recentChangeDate=" + user_recentChangeDate +
                ", user_password='" + user_password + '\'' +
                ", user_roleId='" + user_roleId + '\'' +
                ", user_entryTime=" + user_entryTime +
                '}';
    }
}
