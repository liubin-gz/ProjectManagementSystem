package com.zuikc.bean;

import java.util.List;
import java.util.Set;

public class LoginUser {
    private User user;
    private String user_roleName;
    private List<Resource> user_authority;

    public LoginUser() {
    }

    public LoginUser(User user, String user_roleName, List<Resource> user_authority) {
        this.user = user;
        this.user_roleName = user_roleName;
        this.user_authority = user_authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUser_roleName() {
        return user_roleName;
    }

    public void setUser_roleName(String user_roleName) {
        this.user_roleName = user_roleName;
    }

    public List<Resource> getUser_authority() {
        return user_authority;
    }

    public void setUser_authority(List<Resource> user_authority) {
        this.user_authority = user_authority;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "user=" + user +
                ", user_roleName='" + user_roleName + '\'' +
                ", user_authority=" + user_authority +
                '}';
    }
}
