package com.zuikc.web.resourceServlet;

import com.zuikc.bean.Resource;
import com.zuikc.service.ResourceService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddResourceServlet",urlPatterns = "/addResource")
public class AddResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null&&action.equals("add")){
            request.getRequestDispatcher("/checkResourceDirectory").forward(request,response);
            return;
        }else {
            Resource resource = new Resource();
            try {
                BeanUtils.populate(resource,request.getParameterMap());
                resource.setResource_status("启用");
                if(request.getParameter("resource_parentDirectory").isEmpty()){
                    resource.setResource_parentDirectory(null);
                }
                ResourceService resourceService = new ResourceService();
                //System.out.println(resource);
                int num = resourceService.addResource(resource);
                response.sendRedirect("/ProjectManagementSystem/pageListResource?pageNum=1&num="+num);
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
