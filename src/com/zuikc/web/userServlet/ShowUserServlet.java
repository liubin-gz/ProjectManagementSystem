package com.zuikc.web.userServlet;

import com.zuikc.bean.User;
import com.zuikc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowUserServlet",urlPatterns ="/showUser")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String action = request.getParameter("action");
        String pageNum = request.getParameter("pageNum");
        UserService userService = new UserService();
        User user = userService.showUser(user_id);
        request.setAttribute("pNum",pageNum);
        request.setAttribute("user",user);
        if (action.equals("user_edit")){
            request.getRequestDispatcher("/checkRoleNames").forward(request,response);
            return;
        }else if(action.equals("user_look")){
            request.getRequestDispatcher("/user-look.jsp").forward(request,response);
            return;
        }
    }
}
