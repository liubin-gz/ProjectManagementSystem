package com.zuikc.web.resourceServlet;

import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelResourceServlet",urlPatterns = "/delResource")
public class DelResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resource_id = request.getParameter("resource_id");
        ResourceService resourceService = new ResourceService();
        int num = resourceService.delResource(resource_id);
        response.sendRedirect("/ProjectManagementSystem/pageListResource?pageNum=1&num="+num+"");
    }
}
