package com.zuikc.web.resourceServlet;

import com.zuikc.bean.Resource;
import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckResourceDirectoryServlet",urlPatterns = "/checkResourceDirectory")
public class CheckResourceDirectoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ResourceService resourceService = new ResourceService();
        List<Resource> resourceList = resourceService.listResource();

        request.setAttribute("resourceList",resourceList);
        if(action.equals("add")){
            request.getRequestDispatcher("/resources-add.jsp").forward(request,response);
            return;
        }else if(action.equals("edit")){
            request.getRequestDispatcher("/resources-edit.jsp").forward(request,response);
            return;
        }else if(action.equals("role_add")){
            request.getRequestDispatcher("/role-add.jsp").forward(request,response);
            return;
        }else if (action.equals("role_edit")){
            request.getRequestDispatcher("/role-edit.jsp").forward(request,response);
            return;
        }else if(action.equals("role_look")){
            request.getRequestDispatcher("/role-look.jsp").forward(request,response);
            return;
        }
    }
}
