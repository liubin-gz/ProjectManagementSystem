package com.zuikc.web.userServlet;

import com.zuikc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeUserStatusServlet",urlPatterns = "/changeUserStatus")
public class ChangeUserStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_ids = request.getParameter("user_ids");
        String[] args = user_ids.split(",");
        UserService userService = new UserService();

        //万一以后要改成启用
        String status = "注销";
        userService.changeUserStatus(args,status);
        response.sendRedirect("/ProjectManagementSystem/pageListUser?pageNum=1");
    }
}
