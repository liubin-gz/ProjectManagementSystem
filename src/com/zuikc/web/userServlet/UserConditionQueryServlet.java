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

@WebServlet(name = "UserConditionQueryServlet",urlPatterns = "/userConditionQuery")
public class UserConditionQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        String orderby = request.getParameter("orderby");
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        if(!conditionName.isEmpty()&&!orderby.isEmpty()){
            //如果都选了
            UserService userService = new UserService();
            PageBean<User> userPageBean = userService.userConditionQuery(conditionName, conditionValue, orderby, pageNum);
            request.setAttribute("pageBean",userPageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.setAttribute("orderby",orderby);
            request.getRequestDispatcher("/pageListUser").forward(request,response);
            return;
        }else if(conditionName.isEmpty()&&orderby.isEmpty()){
            //如果都没有选
            request.getRequestDispatcher("/pageListUser").forward(request,response);
            return;
        }else if(!conditionName.isEmpty()&&orderby.isEmpty()){
            //如果只选了搜索条件
            if (conditionValue.isEmpty()){
                request.getRequestDispatcher("/pageListUser").forward(request,response);
                return;
            }
            UserService userService = new UserService();
            PageBean<User> userPageBean = userService.userConditionQuery(conditionName, conditionValue, pageNum);
            request.setAttribute("pageBean",userPageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.getRequestDispatcher("/pageListUser").forward(request,response);
            return;
        }else if(conditionName.isEmpty()&&!orderby.isEmpty()){
            //如果只选了时间排序
            UserService userService = new UserService();
            PageBean<User> userPageBean = userService.userConditionQuery(orderby, pageNum);
            request.setAttribute("pageBean",userPageBean);
            request.setAttribute("orderby",orderby);
            request.getRequestDispatcher("/pageListUser").forward(request,response);
            return;
        }else {
            throw new RuntimeException("什么情况");
        }
    }
}
