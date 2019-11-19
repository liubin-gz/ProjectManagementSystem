package com.zuikc.web.roleServlet;

import com.zuikc.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelRoleServlet",urlPatterns = "/delRole")
public class DelRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role_id = request.getParameter("role_id");
        RoleService roleService = new RoleService();
        int num = roleService.delRole(role_id);
        response.sendRedirect("/ProjectManagementSystem/pageListRole?pageNum=1&num="+num+"");
    }
}
