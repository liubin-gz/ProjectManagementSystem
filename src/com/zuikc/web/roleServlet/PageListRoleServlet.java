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

@WebServlet(name = "PageListRoleServlet",urlPatterns = "/pageListRole")
public class PageListRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));//返回到进入的页面
        String num = request.getParameter("num"); //接受修改信息的状态
        PageBean<Role> rolePageBean = (PageBean<Role>)request.getAttribute("pageBean");

        if (rolePageBean!=null){
            request.getRequestDispatcher("/role.jsp").forward(request,response);
        }else {
            RoleService roleService = new RoleService();
            rolePageBean = roleService.pageListCustomer(pageNum);
            request.setAttribute("pageBean",rolePageBean);
            request.setAttribute("num",num);
            request.getRequestDispatcher("/role.jsp").forward(request,response);
        }
    }
}
