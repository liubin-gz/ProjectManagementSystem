package com.zuikc.web.customerServlet;

import com.zuikc.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelCustomerServlet",urlPatterns = "/delCustomer")
public class DelCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_ids = request.getParameter("customer_ids");
        String[] args = customer_ids.split(",");
        CustomerService customerService = new CustomerService();
        customerService.delBatch(args);
        response.sendRedirect("/ProjectManagementSystem/pageListCustomer?pageNum=1");
    }
}
