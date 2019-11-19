package com.zuikc.service;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.User;
import com.zuikc.dao.UserDao;

import java.util.List;

public class UserService {
    //添加用户
    public int addUser(User user){
        UserDao userDao = new UserDao();
        return userDao.addUser(user);
    }

    //分页查询用户
    public PageBean<User> pageListUser(int pageNum) {
        int pageSize=10;  //每页几条数据
        int start=(pageNum-1)*pageSize;
        UserDao userDao =new UserDao();
        List<User> userList= userDao.pageListUser(start,pageSize);
        int totalCount=userDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;

        PageBean<User> userPageBean=new PageBean<User>();
        userPageBean.setPageNum(pageNum);
        userPageBean.setPageSize(pageSize);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPageNum(totalPageNum);
        userPageBean.setBeanList(userList);

        return userPageBean;
    }

    //按条件分页查询用户
    public PageBean<User> userConditionQuery(String conditionName,String conditionValue,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        UserDao userDao=new UserDao();

        List<User> userList=userDao.userConditionQuery(conditionName,conditionValue,start,pageSize);
        int totalCount=userDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        PageBean<User> userPageBean=new PageBean<User>();
        userPageBean.setPageNum(pageNum);
        userPageBean.setPageSize(pageSize);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPageNum(totalPageNum);
        userPageBean.setBeanList(userList);

        return userPageBean;
    }

    //带有顺序的按条件分页查询客户
    public PageBean<User> userConditionQuery(String conditionName,String conditionValue, String orderby,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        UserDao userDao=new UserDao();

        List<User> userList=userDao.userConditionQuery(conditionName,conditionValue, orderby,start,pageSize);

        //页数问题出在这里！
        int totalCount=userDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        PageBean<User> userPageBean=new PageBean<User>();
        userPageBean.setPageNum(pageNum);
        userPageBean.setPageSize(pageSize);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPageNum(totalPageNum);
        userPageBean.setBeanList(userList);

        return userPageBean;
    }

    //只按顺序查询客户
    public PageBean<User> userConditionQuery(String orderby,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        UserDao userDao=new UserDao();

        List<User> userList=userDao.userConditionQuery(orderby,start,pageSize);
        int totalCount=userDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        PageBean<User> userPageBean=new PageBean<User>();
        userPageBean.setPageNum(pageNum);
        userPageBean.setPageSize(pageSize);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPageNum(totalPageNum);
        userPageBean.setBeanList(userList);

        return userPageBean;
    }

    //注销用户
    public void changeUserStatus(String[] args, String status) {
        UserDao userDao = new UserDao();
        userDao.changeUserStatus(args,status);
    }

    //删除用户
    public int delUser(String user_id) {
        UserDao userDao = new UserDao();
        return userDao.delUser(user_id);
    }

    //根据id查询用户信息
    public User showUser(String user_id) {
        UserDao userDao = new UserDao();
        return userDao.showUser(user_id);
    }

    //根据身份证号查询用户信息
    public User userLogin(String user_name) {
        UserDao userDao = new UserDao();
        return userDao.userLogin(user_name);
    }

    //根据id修改用户信息
    public int editUser(User user) {
        UserDao userDao = new UserDao();
        return userDao.editUser(user);
    }

    //根据id改用户密码
    public void updatePassword(String user_id, String newPassword) {
        UserDao userDao = new UserDao();
        userDao.updatePassword(user_id,newPassword);
    }
}
