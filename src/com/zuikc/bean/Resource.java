package com.zuikc.bean;

public class Resource {
    private String resource_id;
    private String resource_name;
    private String resource_parentDirectory;
    private String resource_path;
    private String resource_status;
    private String resource_remark;

    public Resource(String resource_id, String resource_name, String resource_parentDirectory, String resource_path, String resource_status, String resource_remark) {
        this.resource_id = resource_id;
        this.resource_name = resource_name;
        this.resource_parentDirectory = resource_parentDirectory;
        this.resource_path = resource_path;
        this.resource_status = resource_status;
        this.resource_remark = resource_remark;
    }

    public Resource() {
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public void setResource_parentDirectory(String resource_parentDirectory) {
        this.resource_parentDirectory = resource_parentDirectory;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }

    public void setResource_remark(String resource_remark) {
        this.resource_remark = resource_remark;
    }

    public void setResource_status(String resource_status) {
        this.resource_status = resource_status;
    }

    public String getResource_status() {
        return resource_status;
    }

    public String getResource_name() {
        return resource_name;
    }

    public String getResource_parentDirectory() {
        return resource_parentDirectory;
    }

    public String getResource_path() {
        return resource_path;
    }

    public String getResource_remark() {
        return resource_remark;
    }

    public String getResource_id() {
        return resource_id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resource_id='" + resource_id + '\'' +
                ", resource_name='" + resource_name + '\'' +
                ", resource_parentDirectory='" + resource_parentDirectory + '\'' +
                ", resource_path='" + resource_path + '\'' +
                ", resource_status='" + resource_status + '\'' +
                ", resource_remark='" + resource_remark + '\'' +
                '}';
    }
}
