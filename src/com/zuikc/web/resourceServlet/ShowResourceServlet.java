package com.zuikc.web.resourceServlet;

import com.zuikc.bean.Resource;
import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowResourceServlet",urlPatterns = "/showResource")
public class ShowResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resource_id = request.getParameter("resource_id");
        String action = request.getParameter("action");
        String pageNum = request.getParameter("pageNum");
        ResourceService resourceService = new ResourceService();
        Resource resource = resourceService.showResource(resource_id);
        //System.out.println(action);
        request.setAttribute("pNum",pageNum);
        request.setAttribute("resource",resource);

        //拓展,如果需要查看的话加if（look）
        if (action.equals("edit")){
            request.getRequestDispatcher("/checkResourceDirectory").forward(request,response);
            return;
        }
    }
}
