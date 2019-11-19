package com.zuikc.web.roleServlet;

import com.zuikc.bean.Role;
import com.zuikc.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckRoleNamesServlet",urlPatterns = "/checkRoleNames")
public class CheckRoleNamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.listRole();

        request.setAttribute("roleList",roleList);
        if(action.equals("user_add")){
            request.getRequestDispatcher("/user-add.jsp").forward(request,response);
            return;
        }else if(action.equals("user_edit")){
            request.getRequestDispatcher("/user-edit.jsp").forward(request,response);
            return;
        }
    }
}
