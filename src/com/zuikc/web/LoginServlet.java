package com.zuikc.web;

import com.zuikc.bean.LoginUser;
import com.zuikc.bean.Resource;
import com.zuikc.bean.Role;
import com.zuikc.bean.User;
import com.zuikc.service.ResourceService;
import com.zuikc.service.RoleService;
import com.zuikc.service.UserService;
import com.zuikc.utils.DigestUtls;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

//登录程序
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String verificationCode=request.getParameter("verificationCode");
        String code=(String)request.getSession().getAttribute("verificationCode");
//       用完就销毁
        request.getSession().invalidate();
        if(verificationCode==null||!code.equals(verificationCode)){
//            验证码输入错误，或者验证码无效
            request.setAttribute("msg",1);
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        String user_name=request.getParameter("user_name");
        String pass_word= DigestUtls.md5(request.getParameter("user_password"));

        UserService userService = new UserService();
        User user = userService.userLogin(user_name);
        if(user.getUser_name().equals(user_name)&&user.getUser_password().equals(pass_word)){
//            登录成功了
            //找对应角色
            List<Role> roleList = new ArrayList<>();
            RoleService roleService = new RoleService();
            String user_roleIds = user.getUser_roleId();
            String[] user_roleId = user_roleIds.split(",");
            for (String id:user_roleId){
                Role role = roleService.showRole(id.trim());
                roleList.add(role);
            }

            //找对应菜单资源
            List<Resource> resourceList = new ArrayList<>();
            ResourceService resourceService = new ResourceService();
            for (Role role:roleList){
                String role_authorities = role.getRole_authority();
                String[] role_authority = role_authorities.split(",");
                for (String authority:role_authority){
                    Resource resource = resourceService.showResource(authority.trim());
                    resourceList.add(resource);
                }
            }

            //找对应角色名字
            String user_roleName = "";
            for (Role role:roleList){
                user_roleName+=role.getRole_name()+",";
            }
            user_roleName = user_roleName.substring(0,user_roleName.length()-1);

            //找对应资源id
            Set<String> user_authority = new HashSet<>();
            for (Resource resource:resourceList){
                user_authority.add(resource.getResource_id());
            }

            //权限资源
            List<Resource> newResourceList = new ArrayList<>();
            for (String authority:user_authority){
                Resource resource = resourceService.showResource(authority);
                newResourceList.add(resource);
            }

            LoginUser loginUser = new LoginUser(user,user_roleName,newResourceList);
            request.getSession().setAttribute("loginUser",loginUser);
            request.getSession().setMaxInactiveInterval(60*60*2);
            //System.out.println(loginUser);
            response.sendRedirect("/ProjectManagementSystem/index.jsp");
            return;
        }else{
//            登录失败
            request.setAttribute("msg",2);
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
