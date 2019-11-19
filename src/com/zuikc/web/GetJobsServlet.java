package com.zuikc.web;

import com.zuikc.bean.Job;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetJobsServlet",urlPatterns = "/getJobs")
public class GetJobsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("job_1","初级开发工程师"));
        jobs.add(new Job("job_2","中级开发工程师"));
        jobs.add(new Job("job_3","高级开发工程师"));
        jobs.add(new Job("job_4","项目经理"));
        jobs.add(new Job("job_5","项目助理"));
        jobs.add(new Job("job_6","策划"));
        jobs.add(new Job("job_7","其它"));
        //System.out.println(JSONArray.fromObject(provinces).toString());
        response.getWriter().println(JSONArray.fromObject(jobs).toString());
    }
}
