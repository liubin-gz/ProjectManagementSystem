package com.zuikc.web.userServlet;

import com.zuikc.bean.LoginUser;
import com.zuikc.bean.User;
import com.zuikc.service.UserService;
import com.zuikc.utils.DigestUtls;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordServlet",urlPatterns = "/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = DigestUtls.md5(request.getParameter("oldPassword"));
        String newPassword = DigestUtls.md5(request.getParameter("newPassword"));
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute("loginUser");
        String user_id = loginUser.getUser().getUser_id();
        UserService userService = new UserService();
        User user = userService.showUser(user_id);
        if (user.getUser_password().equals(oldPassword)){
            userService.updatePassword(user_id,newPassword);
            request.getSession().invalidate();
            response.sendRedirect("/ProjectManagementSystem/index.jsp");
        }else {
            request.setAttribute("fail",0);
            request.getRequestDispatcher("/modpassword.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
