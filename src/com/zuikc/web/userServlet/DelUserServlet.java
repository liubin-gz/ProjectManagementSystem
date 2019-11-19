package com.zuikc.web.userServlet;

import com.zuikc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelUserServlet",urlPatterns = "/delUser")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        UserService userService = new UserService();
        int num = userService.delUser(user_id);
        response.sendRedirect("/ProjectManagementSystem/pageListUser?pageNum=1&num="+num+"");
    }
}
