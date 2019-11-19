package com.zuikc.dao;

import com.zuikc.bean.Resource;
import com.zuikc.utils.JDBCUtils;
import com.zuikc.web.resourceServlet.CheckResourceDirectoryServlet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ResourceDao {

    //查询所有资源记录
    public List<Resource> listResource(){
        String sql="select * from resource";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Resource> resourceList = queryRunner.query(sql, new BeanListHandler<Resource>(Resource.class));
            return resourceList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //分页查询资源信息
    public List<Resource> pageListResource(int start,int pageSize){
        String sql = "select * from resource limit ?,?";
        Object[] args = {start,pageSize};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Resource> resources = queryRunner.query(sql, new BeanListHandler<Resource>(Resource.class),args);
            //System.out.println(start+"------"+pageSize+"-------"+resources);
            return resources;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //    查询总记录条数
    public int findCount() {
        String sql="select count(*) from resource";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        try {
            long  totalCount=(Long)qr.query(sql,new ScalarHandler(1));
            return (int)totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    //按条件分页查询资源
    public List<Resource> resourceConditionQuery(String conditionName, String conditionValue, int start, int pageSize) {
        String sql = "select * from resource where "+conditionName+" like ? limit ?,?";
        String likeStr = "%"+conditionValue+"%";
        Object[] args = {likeStr,start,pageSize};
        //System.out.println(conditionName+"---"+conditionValue+"---"+start+"---"+pageSize);
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Resource> resources = queryRunner.query(sql, new BeanListHandler<Resource>(Resource.class), args);
            return resources;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //带有条件的资源数
    public int findCount(String conditionName, String conditionValue) {
        String sql="select count(*) from resource where "+conditionName+" like ?";
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

    //根据id批量更改资源的状态
    public void changeResourceStatus(String[] ids, String status) {
        for(String id:ids){
            this.changeResourceStatus(id,status);
        }
    }

    //根据id更改资源的状态
    public void changeResourceStatus(String resource_id, String status) {
        String sql="update resource set resource_status=? where resource_id=?";
        Object[] args = {status,resource_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            queryRunner.update(sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //添加资源
    public int addResource(Resource resource) {
        String sql = "insert into resource values(?,?,?,?,?,?)";
        Object[] args = {resource.getResource_id(),resource.getResource_name(),resource.getResource_parentDirectory(),
                resource.getResource_path(),resource.getResource_status(),resource.getResource_remark()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = queryRunner.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id查资源信息
    public Resource showResource(String resource_id) {
        String sql = "select * from resource where resource_id=?";
        Object[] args = {resource_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Resource resource = queryRunner.query(sql, new BeanHandler<Resource>(Resource.class), args);
            return resource;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id改资源信息
    public int editResource(Resource resource){
        String sql="update resource set resource_name=?,resource_parentDirectory=?,resource_path=?,resource_remark=? where resource_id=?";
        Object[] args = {resource.getResource_name(),resource.getResource_parentDirectory(),resource.getResource_path(),resource.getResource_remark(),resource.getResource_id()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int num = queryRunner.update(sql, args);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //根据id删除资源信息
    public int delResource(String resource_id) {
        String sql = "delete from resource where resource_id=?";
        Object[] args = {resource_id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int update = queryRunner.update(sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
