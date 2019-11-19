package com.zuikc.web.userServlet;

import com.zuikc.bean.User;
import com.zuikc.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Arrays;

@WebServlet(name = "AddUserServlet",urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null&&action.equals("user_add")){
            request.getRequestDispatcher("/checkRoleNames").forward(request,response);
            return;
        }else {
            User user = new User();
            try {
                BeanUtils.populate(user,request.getParameterMap());
                //权限
                String[] user_roleIds = request.getParameterValues("user_roleId");
                String user_roleId = Arrays.toString(user_roleIds);
                user_roleId = user_roleId.substring(1,user_roleId.length()-1);
                user.setUser_roleId(user_roleId);
                //添加时间
                Date date = new Date(new java.util.Date().getTime());
                user.setUser_insertDate(date);
                user.setUser_status("正常");

                UserService userService = new UserService();
                int num = userService.addUser(user);
                response.sendRedirect("/ProjectManagementSystem/pageListUser?pageNum=1&num="+num);
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
