package com.zuikc.web.resourceServlet;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.Resource;
import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResourceConditionQueryServlet",urlPatterns = "/resourceConditionQuery")
public class ResourceConditionQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        //System.out.println(conditionName+"----"+conditionValue+"----"+pageNum);
        if(conditionName.isEmpty()){
            request.getRequestDispatcher("/pageListResource").forward(request,response);
            return;
        }else{
            if(conditionValue.isEmpty()){
                request.getRequestDispatcher("/pageListResource").forward(request,response);
                return;
            }
            ResourceService resourceService = new ResourceService();
            PageBean<Resource> resourcePageBean = resourceService.resourceConditionQuery(conditionName, conditionValue, pageNum);
            request.setAttribute("pageBean",resourcePageBean);
            request.setAttribute("conditionName",conditionName);
            request.setAttribute("conditionValue",conditionValue);
            request.getRequestDispatcher("/pageListResource").forward(request,response);
            return;
        }
    }
}
