package com.zuikc.service;

import com.zuikc.bean.Customer;
import com.zuikc.bean.CustomerPageBean;
import com.zuikc.dao.CustomerDao;

import java.util.List;

public class CustomerService {

    //添加客户
    public int addCustomer(Customer customer){
        CustomerDao customerDao = new CustomerDao();
        return customerDao.addCustomer(customer);
    }

    //分页查询所有客户
    public CustomerPageBean pageListCustomer(int pageNum){
        int pageSize=10;  //每页几条数据
        int start=(pageNum-1)*pageSize;
        CustomerDao customerDao=new CustomerDao();
        List<Customer> customers=customerDao.pageListCustomer(start,pageSize);
        int totalCount=customerDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;

        CustomerPageBean pageBean=new CustomerPageBean();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPageNum(totalPageNum);
        pageBean.setCustomers(customers);

        return pageBean;
    }

    //按条件分页查询客户
    public CustomerPageBean CustomerConditionQuery(String conditionName,String conditionValue,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        CustomerDao customerDao=new CustomerDao();

        List<Customer> customers=customerDao.CustomerConditionQuery(conditionName,conditionValue,start,pageSize);
        int totalCount=customerDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        CustomerPageBean pageBean=new CustomerPageBean();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPageNum(totalPageNum);
        pageBean.setCustomers(customers);

        return pageBean;
    }

    //带有顺序的按条件分页查询客户
    public CustomerPageBean CustomerConditionQuery(String conditionName,String conditionValue, String orderby,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        CustomerDao customerDao=new CustomerDao();

        List<Customer> customers=customerDao.CustomerConditionQuery(conditionName,conditionValue, orderby,start,pageSize);

        //页数问题出在这里！
        int totalCount=customerDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        CustomerPageBean pageBean=new CustomerPageBean();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPageNum(totalPageNum);
        pageBean.setCustomers(customers);

        return pageBean;
    }

    //只按顺序查询客户
    public CustomerPageBean CustomerConditionQuery(String orderby,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        CustomerDao customerDao=new CustomerDao();

        List<Customer> customers=customerDao.CustomerConditionQuery(orderby,start,pageSize);
        int totalCount=customerDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        CustomerPageBean pageBean=new CustomerPageBean();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPageNum(totalPageNum);
        pageBean.setCustomers(customers);

        return pageBean;
    }

    //根据id查询指定客户信息
    public Customer showCustomer(String customer_id){
        CustomerDao customerDao = new CustomerDao();
        return customerDao.showCustomer(customer_id);
    }

    //改客户
    public int editCustomer(Customer customer) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.editCustomer(customer);
    }

    //根据id来删除用户
    public void delBatch(String[] customer_ids) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.delBatch(customer_ids);
    }
}
