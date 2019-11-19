package com.zuikc.service;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.Role;
import com.zuikc.dao.RoleDao;

import java.util.List;

public class RoleService {

    //改角色信息
    public int editRole(Role role) {
        RoleDao roleDao = new RoleDao();
        return roleDao.editRole(role);
    }

    //分页查询所有角色
    public PageBean<Role> pageListCustomer(int pageNum) {
        int pageSize=10;  //每页几条数据
        int start=(pageNum-1)*pageSize;
        RoleDao roleDao =new RoleDao();
        List<Role> roleList= roleDao.pageListResource(start,pageSize);
        int totalCount=roleDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;

        PageBean<Role> rolePageBean=new PageBean<Role>();
        rolePageBean.setPageNum(pageNum);
        rolePageBean.setPageSize(pageSize);
        rolePageBean.setTotalCount(totalCount);
        rolePageBean.setTotalPageNum(totalPageNum);
        rolePageBean.setBeanList(roleList);

        return rolePageBean;
    }

    //条件分页查角色
    public PageBean<Role> roleConditionQuery(String conditionName, String conditionValue, int pageNum) {
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        RoleDao roleDao =new RoleDao();

        List<Role> roleList=roleDao.roleConditionQuery(conditionName,conditionValue,start,pageSize);
        int totalCount=roleDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        PageBean<Role> rolePageBean=new PageBean<Role>();
        rolePageBean.setPageNum(pageNum);
        rolePageBean.setPageSize(pageSize);
        rolePageBean.setTotalCount(totalCount);
        rolePageBean.setTotalPageNum(totalPageNum);
        rolePageBean.setBeanList(roleList);

        return rolePageBean;
    }

    //根据id删除角色
    public int delRole(String role_id) {
        RoleDao roleDao = new RoleDao();
        return roleDao.delRole(role_id);
    }

    //根据id批量更改角色状态
    public void changeRoleStatus(String[] args, String status) {
        RoleDao roleDao = new RoleDao();
        roleDao.changeRoleStatus(args,status);
    }

    //添加角色
    public int addRole(Role role) {
        RoleDao roleDao = new RoleDao();
        return roleDao.addRole(role);
    }

    //根据id查询角色
    public Role showRole(String role_id) {
        RoleDao roleDao = new RoleDao();
        return roleDao.showRole(role_id);
    }

    //查询所有角色
    public List<Role> listRole() {
        RoleDao roleDao = new RoleDao();
        return roleDao.listRole();
    }
}
