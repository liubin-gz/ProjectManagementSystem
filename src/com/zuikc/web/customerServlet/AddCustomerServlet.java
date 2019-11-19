package com.zuikc.web.customerServlet;

import com.zuikc.bean.Customer;
import com.zuikc.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

@WebServlet(name = "AddCustomerServlet",urlPatterns = "/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer,request.getParameterMap());
            Date date = new Date(new java.util.Date().getTime());
            customer.setCustomer_insertDate(date);
            //System.out.println(customer);
            CustomerService customerService = new CustomerService();
            int num = customerService.addCustomer(customer);

            response.sendRedirect("/ProjectManagementSystem/pageListCustomer?pageNum=1&num="+num);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
