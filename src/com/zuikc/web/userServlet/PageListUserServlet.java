package com.zuikc.web.userServlet;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.User;
import com.zuikc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageListUserServlet",urlPatterns = "/pageListUser")
public class PageListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));//返回到进入的页面
        String num = request.getParameter("num"); //接受修改信息的状态
        PageBean<User> userPageBean = (PageBean<User>)request.getAttribute("pageBean");

        if (userPageBean!=null){
            request.getRequestDispatcher("/user.jsp").forward(request,response);
        }else {
            UserService userService = new UserService();
            userPageBean = userService.pageListUser(pageNum);
            request.setAttribute("pageBean",userPageBean);
            request.setAttribute("num",num);
            request.getRequestDispatcher("/user.jsp").forward(request,response);
        }
    }
}
