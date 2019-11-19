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

@WebServlet(name = "EditResourceServlet",urlPatterns = "/editResource")
public class EditResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //System.out.println(action);
        if(action!=null&&action.equals("edit")){
            request.getRequestDispatcher("/showResource").forward(request,response);
            return;
        }else {
            Resource resource = new Resource();
            try {
                BeanUtils.populate(resource,request.getParameterMap());
                ResourceService resourceService = new ResourceService();
                if(request.getParameter("resource_parentDirectory").isEmpty()){
                    resource.setResource_parentDirectory(null);
                }
                int num = resourceService.editResource(resource);
                String pNum = request.getParameter("pageNum");
                response.sendRedirect("/ProjectManagementSystem/pageListResource?pageNum="+pNum+"&num="+num+"");
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
