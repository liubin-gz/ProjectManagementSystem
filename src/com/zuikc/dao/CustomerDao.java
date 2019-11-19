package com.zuikc.dao;

import com.zuikc.bean.Customer;
import com.zuikc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CustomerDao {

    //添加用户
    public int addCustomer(Customer customer){
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {JDBCUtils.generateCustomerId(),customer.getCustomer_name(),customer.getCustomer_companyName(),customer.getCustomer_insertDate(),
                customer.getCustomer_cellphone(),customer.getCustomer_companyAddress(),customer.getCustomer_companyTel(),
                customer.getCustomer_companyIntro(),customer.getCustomer_remark(),null};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = queryRunner.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id查询指定客户信息
    public Customer showCustomer(String customer_id) {
        String sql="select * from customer where customer_id=?";
        Object[]args={customer_id};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            Customer customer=qr.query(sql,new BeanHandler<Customer>(Customer.class),args);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    //分页查询客户信息
    public List<Customer> pageListCustomer(int start,int pageSize){
        String sql = "select * from customer limit ?,?";
        Object[] args = {start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Customer> customers = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class),args);
            //System.out.println(start+"------"+pageSize+"-------"+customers);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //    查询总记录条数
    public int findCount() {
        String sql="select count(*) from customer";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            long  totalCount=(Long)qr.query(sql,new ScalarHandler(1));
            return (int)totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    //带有条件的客户数
    public int findCount(String conditionName, String conditionValue) {
        String sql="select count(*) from customer where "+conditionName+" like ?";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            long  totalCount=(Long)qr.query(sql,new ScalarHandler(1),args);
            return (int)totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    //按条件分页查询客户
    public List<Customer> CustomerConditionQuery(String conditionName, String conditionValue, int start, int pageSize) {
        String sql = "select * from customer where "+conditionName+" like ? limit ?,?";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        //System.out.println(conditionName+"---"+conditionValue+"---"+start+"---"+pageSize);
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Customer> customers = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class), args);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //带有顺序的按条件分页查询客户
    public List<Customer> CustomerConditionQuery(String conditionName, String conditionValue, String orderby,int start, int pageSize) {
        String sql = "select * from customer where "+conditionName+" like ? order by "+orderby+" desc limit ?,? ";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Customer> customers = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class), args);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //只按顺序查询客户
    public List<Customer> CustomerConditionQuery(String orderby,int start, int pageSize) {
        String sql = "select * from customer order by "+orderby+" desc limit ?,? ";
        Object[] args = {start,pageSize};

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Customer> customers = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class), args);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //改客户
    public int editCustomer(Customer customer) {
        String sql = "update customer set customer_name=?,customer_companyName=?,customer_cellphone=?,customer_companyAddress=?,customer_companyTel=?,customer_companyIntro=?,customer_remark=?,customer_recentChangeDate=? where customer_id=?";
        Object[] args = {customer.getCustomer_name(),customer.getCustomer_companyName(),customer.getCustomer_cellphone(),
                customer.getCustomer_companyAddress(),customer.getCustomer_companyTel(),customer.getCustomer_companyIntro(),
                customer.getCustomer_remark(),customer.getCustomer_recentChangeDate(),customer.getCustomer_id()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id删客户
    public int delCustomer(String customer_id) {
        String sql="delete from customer where customer_id=?";
        Object[] args={customer_id};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = qr.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);//转换为运行时期异常抛出
        }
    }

    //根据id批量删除客户
    public void delBatch(String[] ids) {
        for(String id:ids){
            //System.out.println(id);
            this.delCustomer(id);
        }
    }
}
