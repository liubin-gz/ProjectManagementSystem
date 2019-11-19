package com.zuikc.web.customerServlet;

import com.zuikc.bean.CustomerPageBean;
import com.zuikc.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerConditionQueryServlet",urlPatterns = "/CustomerConditionQuery")
public class CustomerConditionQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        String orderby = request.getParameter("orderby");
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        // System.out.println(conditionName+"----"+conditionValue+"----"+orderby+"----"+pageNum);

        if(!conditionName.isEmpty()&&!orderby.isEmpty()){
            //如果都选了
            CustomerService customerService = new CustomerService();
            CustomerPageBean customerPageBean = customerService.CustomerConditionQuery(conditionName, conditionValue, orderby, pageNum);
            request.setAttribute("pageBean",customerPageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.setAttribute("orderby",orderby);
            request.getRequestDispatcher("/pageListCustomer").forward(request,response);
            return;
        }else if(conditionName.isEmpty()&&orderby.isEmpty()){
            //如果都没有选
            request.getRequestDispatcher("/pageListCustomer").forward(request,response);
            return;
        }else if(!conditionName.isEmpty()&&orderby.isEmpty()){
            //如果只选了搜索条件
            if (conditionValue.isEmpty()){
                request.getRequestDispatcher("/pageListCustomer").forward(request,response);
                return;
            }
            CustomerService customerService = new CustomerService();
            CustomerPageBean customerPageBean = customerService.CustomerConditionQuery(conditionName, conditionValue, pageNum);
            request.setAttribute("pageBean",customerPageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.getRequestDispatcher("/pageListCustomer").forward(request,response);
            return;
        }else if(conditionName.isEmpty()&&!orderby.isEmpty()){
            //如果只选了时间排序
            CustomerService customerService = new CustomerService();
            CustomerPageBean customerPageBean = customerService.CustomerConditionQuery(orderby, pageNum);
            request.setAttribute("pageBean",customerPageBean);
            request.setAttribute("orderby",orderby);
            request.getRequestDispatcher("/pageListCustomer").forward(request,response);
            return;
        }else {
            throw new RuntimeException("什么情况");
        }

    }
}
