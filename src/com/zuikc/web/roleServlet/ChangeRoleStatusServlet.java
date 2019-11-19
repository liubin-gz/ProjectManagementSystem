package com.zuikc.web.roleServlet;

import com.zuikc.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeRoleStatusServlet",urlPatterns = "/changeRoleStatus")
public class ChangeRoleStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role_ids = request.getParameter("role_ids");
        String[] args = role_ids.split(",");
        RoleService roleService = new RoleService();

        //万一以后要改成启用
        String status = "禁用";
        roleService.changeRoleStatus(args,status);
        response.sendRedirect("/ProjectManagementSystem/pageListRole?pageNum=1");
    }
}
