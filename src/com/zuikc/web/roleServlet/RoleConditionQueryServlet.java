package com.zuikc.web.roleServlet;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.Role;
import com.zuikc.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RoleConditionQueryServlet",urlPatterns = "/roleConditionQuery")
public class RoleConditionQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        if(conditionName.isEmpty()){
            request.getRequestDispatcher("/pageListRole").forward(request,response);
            return;
        }else{
            if(conditionValue.isEmpty()){
                request.getRequestDispatcher("/pageListRole").forward(request,response);
                return;
            }
            RoleService roleService = new RoleService();
            PageBean<Role> rolePageBean = roleService.roleConditionQuery(conditionName, conditionValue, pageNum);
            request.setAttribute("pageBean",rolePageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.getRequestDispatcher("/pageListRole").forward(request,response);
            return;
        }
    }
}
