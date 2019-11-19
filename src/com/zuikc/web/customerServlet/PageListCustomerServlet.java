package com.zuikc.web.customerServlet;

import com.zuikc.bean.Customer;
import com.zuikc.bean.CustomerPageBean;
import com.zuikc.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageListCustomerServlet",urlPatterns = "/pageListCustomer")
public class PageListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        String num = request.getParameter("num");
        CustomerPageBean customerPageBean = (CustomerPageBean)request.getAttribute("pageBean");

        if (customerPageBean!=null){
            request.getRequestDispatcher("/customer.jsp").forward(request,response);
        }else {
            CustomerService customerService = new CustomerService();
            customerPageBean = customerService.pageListCustomer(pageNum);
            //System.out.println(customerPageBean);
            request.setAttribute("pageBean",customerPageBean);
            request.setAttribute("num",num);
            request.getRequestDispatcher("/customer.jsp").forward(request,response);
        }

    }
}
