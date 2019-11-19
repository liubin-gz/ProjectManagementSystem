package com.zuikc.bean;

public class Role {
    private String role_id;
    private String role_name;
    private String role_status;
    private String role_authority;
    private String role_remark;

    public Role() {
    }

    public Role(String role_id, String role_name, String role_status, String role_authority, String role_remark) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_status = role_status;
        this.role_authority = role_authority;
        this.role_remark = role_remark;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setRole_status(String role_status) {
        this.role_status = role_status;
    }

    public void setRole_authority(String role_authority) {
        this.role_authority = role_authority;
    }

    public void setRole_remark(String role_remark) {
        this.role_remark = role_remark;
    }

    public String getRole_id() {
        return role_id;
    }


    public String getRole_name() {
        return role_name;
    }

    public String getRole_status() {
        return role_status;
    }

    public String getRole_authority() {
        return role_authority;
    }

    public String getRole_remark() {
        return role_remark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_status='" + role_status + '\'' +
                ", role_authority='" + role_authority + '\'' +
                ", role_remark='" + role_remark + '\'' +
                '}';
    }
}
