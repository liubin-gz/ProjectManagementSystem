package com.zuikc.web.customerServlet;

import com.zuikc.bean.Customer;
import com.zuikc.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowCustomerServlet",urlPatterns = "/showCustomer")
public class ShowCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_id = request.getParameter("customer_id");
        String action = request.getParameter("action");
        String pageNum = request.getParameter("pageNum");
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.showCustomer(customer_id);
        //System.out.println(action);
        request.setAttribute("pNum",pageNum);
        request.setAttribute("customer",customer);
        if (action.equals("edit")){
            request.getRequestDispatcher("/customer-edit.jsp").forward(request,response);
            return;
        }else if(action.equals("look")){
            request.getRequestDispatcher("/customer-look.jsp").forward(request,response);
            return;
        }
    }
}
