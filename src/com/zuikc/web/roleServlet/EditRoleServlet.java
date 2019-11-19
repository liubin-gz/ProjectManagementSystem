package com.zuikc.web.roleServlet;

import com.zuikc.bean.Role;
import com.zuikc.service.RoleService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@WebServlet(name = "EditRoleServlet",urlPatterns = "/editRole")
public class EditRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null&&action.equals("role_edit")){
            request.getRequestDispatcher("/showRole").forward(request,response);
            return;
        }else {
            Role role = new Role();
            try {
                BeanUtils.populate(role,request.getParameterMap());
                String[] role_authorities = request.getParameterValues("role_authority");
                String role_authority = Arrays.toString(role_authorities);
                role_authority = role_authority.substring(1,role_authority.length()-1);
                role.setRole_authority(role_authority);

                RoleService roleService = new RoleService();
                int num = roleService.editRole(role);
                String pNum = request.getParameter("pageNum");
                response.sendRedirect("/ProjectManagementSystem/pageListRole?pageNum="+pNum+"&num="+num+"");
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
