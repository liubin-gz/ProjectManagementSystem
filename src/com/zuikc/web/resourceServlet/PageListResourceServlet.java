package com.zuikc.web.resourceServlet;

import com.zuikc.bean.CustomerPageBean;
import com.zuikc.bean.PageBean;
import com.zuikc.bean.Resource;
import com.zuikc.service.CustomerService;
import com.zuikc.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageListResourceServlet",urlPatterns = "/pageListResource")
public class PageListResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));//返回到进入的页面
        String num = request.getParameter("num"); //接受修改信息的状态
        PageBean<Resource> resourcePageBean = (PageBean<Resource>)request.getAttribute("pageBean");

        if (resourcePageBean!=null){
            request.getRequestDispatcher("/resources.jsp").forward(request,response);
        }else {
            ResourceService resourceService = new ResourceService();
            resourcePageBean = resourceService.pageListResource(pageNum);
            //System.out.println(resourcePageBean);
            request.setAttribute("pageBean",resourcePageBean);
            request.setAttribute("num",num);
            request.getRequestDispatcher("/resources.jsp").forward(request,response);
        }

    }
}
