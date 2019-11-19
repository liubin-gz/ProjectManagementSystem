package com.zuikc.web;

import com.zuikc.bean.LoginUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "AuthorityFilter",urlPatterns = "/*")
public class AuthorityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            response.sendRedirect("/ProjectManagementSystem/login.jsp");
            return;
        }*/
        /*万一用户登陆先进去在输入地址呢*/
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
