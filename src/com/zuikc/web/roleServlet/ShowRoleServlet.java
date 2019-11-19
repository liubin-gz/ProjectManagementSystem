package com.zuikc.web.roleServlet;

import com.zuikc.bean.Role;
import com.zuikc.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowRoleServlet",urlPatterns = "/showRole")
public class ShowRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role_id = request.getParameter("role_id");
        String action = request.getParameter("action");
        String pageNum = request.getParameter("pageNum");
        RoleService roleService = new RoleService();
        Role role = roleService.showRole(role_id);
        request.setAttribute("pNum",pageNum);
        request.setAttribute("role",role);
        if (action.equals("role_edit")){
            request.getRequestDispatcher("/checkResourceDirectory").forward(request,response);
            return;
        }else if(action.equals("role_look")){
            request.getRequestDispatcher("/checkResourceDirectory").forward(request,response);
            return;
        }
    }
}
