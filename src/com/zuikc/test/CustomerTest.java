package com.zuikc.test;

import com.zuikc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class CustomerTest {

    @Test
    public void demo1(){
//        批量插入数据
        String sql="insert into customer values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        for(int i=1;i<=100;i++){
            Object[]args={JDBCUtils.generateUserId(),"name"+i,"百度"+(i*2),"2001-1-9","18012341234",
            "中关村","84629758","钻石客户","good good good!","2016-4-9"};
            try {
                qr.update(sql,args);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
