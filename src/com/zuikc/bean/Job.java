package com.zuikc.bean;

public class Job {
    private String job_id;
    private String job_name;

    public Job() {
    }

    public Job(String job_id, String job_name) {
        this.job_id = job_id;
        this.job_name = job_name;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_id() {
        return job_id;
    }

    public String getJob_name() {
        return job_name;
    }
}
