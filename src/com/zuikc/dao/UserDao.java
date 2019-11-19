package com.zuikc.dao;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.User;
import com.zuikc.utils.DigestUtls;
import com.zuikc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserDao {

    //添加用户
    public int addUser(User user){
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {JDBCUtils.generateUserId(),user.getUser_name(),user.getUser_job(),user.getUser_sex(),user.getUser_age(),
                user.getUser_cellphone(),user.getUser_insertDate(),user.getUser_status(),
                user.getUser_idCard(),user.getUser_remark(),null, DigestUtls.md5(user.getUser_idCard()),
                user.getUser_roleId(),user.getUser_entryTime()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = queryRunner.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //分页查询用户
    public List<User> pageListUser(int start, int pageSize) {
        String sql = "select * from user limit ?,?";
        Object[] args = {start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class),args);
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //查询用户数量
    public int findCount() {
        String sql="select count(*) from user";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            long  totalCount=(Long)qr.query(sql,new ScalarHandler(1));
            return (int)totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    //带有条件的用户数
    public int findCount(String conditionName, String conditionValue) {
        String sql="select count(*) from user where "+conditionName+" like ?";
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
    public List<User> userConditionQuery(String conditionName, String conditionValue, int start, int pageSize) {
        String sql = "select * from user where "+conditionName+" like ? limit ?,?";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class), args);
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //带有顺序的按条件分页查询客户
    public List<User> userConditionQuery(String conditionName, String conditionValue, String orderby,int start, int pageSize) {
        String sql = "select * from user where "+conditionName+" like ? order by "+orderby+" desc limit ?,? ";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<User> customers = queryRunner.query(sql, new BeanListHandler<User>(User.class), args);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //只按顺序查询客户
    public List<User> userConditionQuery(String orderby,int start, int pageSize) {
        String sql = "select * from user order by "+orderby+" desc limit ?,? ";
        Object[] args = {start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<User> customers = queryRunner.query(sql, new BeanListHandler<User>(User.class), args);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id批量更改资源的状态
    public void changeUserStatus(String[] ids, String status) {
        for(String id:ids){
            this.changeUserStatus(id,status);
        }
    }

    //根据id更改资源的状态
    public void changeUserStatus(String user_id, String status) {
        String sql="update user set user_status=? where user_id=?";
        Object[] args = {status,user_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            queryRunner.update(sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //删除用户
    public int delUser(String user_id) {
        String sql = "delete from user where user_id=?";
        Object[] args = {user_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id查询用户信息
    public User showUser(String user_id) {
        String sql = "select * from user where user_id=?";
        Object[] args = {user_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), args);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据用户名查询用户信息
    public User userLogin(String user_name) {
        String sql = "select * from user where user_name=?";
        Object[] args = {user_name};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), args);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id修改用户信息
    public int editUser(User user) {
        String sql = "update user set user_job=?,user_name=?,user_sex=?,user_age=?,user_cellphone=?,user_entryTime=?,user_idCard=?,user_roleId=?,user_remark=?,user_recentChangeDate=? where user_id=?";
        Object[] args = {user.getUser_job(),user.getUser_name(),user.getUser_sex(),user.getUser_age(),user.getUser_cellphone(),
                user.getUser_entryTime(),user.getUser_idCard(),user.getUser_roleId(),user.getUser_remark(),
                user.getUser_recentChangeDate(),user.getUser_id()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id改用户密码
    public void updatePassword(String user_id, String newPassword) {
        String sql="update user set user_password=? where user_id=?";
        Object[] args = {newPassword,user_id};
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
