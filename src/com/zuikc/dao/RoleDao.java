package com.zuikc.dao;

import com.zuikc.bean.Role;
import com.zuikc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class RoleDao {

    //分页查询资源信息
    public List<Role> pageListResource(int start, int pageSize) {
        String sql = "select * from role limit ?,?";
        Object[] args = {start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Role> roleList = queryRunner.query(sql, new BeanListHandler<Role>(Role.class),args);
            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //查询总记录条数
    public int findCount() {
        String sql="select count(*) from role";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            long  totalCount=(Long)qr.query(sql,new ScalarHandler(1));
            return (int)totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    //条件分页查询角色信息
    public List<Role> roleConditionQuery(String conditionName, String conditionValue, int start, int pageSize) {
        String sql = "select * from role where "+conditionName+" like ? limit ?,?";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Role> roleList = queryRunner.query(sql, new BeanListHandler<Role>(Role.class), args);
            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //按条件查询的总条数
    public int findCount(String conditionName,String conditionValue) {
        String sql="select count(*) from role where "+conditionName+" like ?";
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

    //根据id删角色
    public int delRole(String role_id) {
        String sql = "delete from role where role_id=?";
        Object[] args = {role_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id批量更改角色状态
    public void changeRoleStatus(String[] ids, String status) {
        for(String id:ids){
            this.ChangeResourceStatus(id,status);
        }
    }

    //根据id改角色状态
    private void ChangeResourceStatus(String role_id, String status) {
        String sql="update role set role_status=? where role_id=?";
        Object[] args = {status,role_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            queryRunner.update(sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //添加角色
    public int addRole(Role role) {
        String sql = "insert into role values(?,?,?,?,?)";
        Object[] args = {role.getRole_id(),role.getRole_name(),role.getRole_status(),role.getRole_authority(),role.getRole_remark()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id查询角色
    public Role showRole(String role_id) {
        String sql = "select * from role where role_id=?";
        Object[] args = {role_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Role role = queryRunner.query(sql, new BeanHandler<Role>(Role.class), args);
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //改角色信息
    public int editRole(Role role) {
        String sql="update role set role_name=?,role_status=?,role_authority=?,role_remark=? where role_id=?";
        Object[] args = {role.getRole_name(),role.getRole_status(),role.getRole_authority(),role.getRole_remark(),role.getRole_id()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = queryRunner.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //查询所有角色信息
    public List<Role> listRole() {
        String sql="select * from role";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Role> roleList = queryRunner.query(sql, new BeanListHandler<Role>(Role.class));
            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
