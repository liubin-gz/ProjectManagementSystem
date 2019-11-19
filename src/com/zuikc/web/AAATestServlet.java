package com.zuikc.web;

import com.zuikc.bean.CustomerPageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AAATestServlet",urlPatterns = "/test")
public class AAATestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*System.out.println(request.getAttribute("pageNum"));
        System.out.println("hello");*/
        System.out.println(request.getParameter("action"));
    }
}
