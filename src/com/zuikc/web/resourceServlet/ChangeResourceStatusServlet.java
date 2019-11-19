package com.zuikc.web.resourceServlet;

import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeResourceStatusServlet",urlPatterns = "/changeResourceStatus")
public class ChangeResourceStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resource_ids = request.getParameter("resource_ids");
        String[] args = resource_ids.split(",");
        ResourceService resourceService = new ResourceService();

        //万一以后要改成启用
        String status = "禁用";
        resourceService.changeResourceStatus(args,status);
        response.sendRedirect("/ProjectManagementSystem/pageListResource?pageNum=1");
    }
}
