package com.zuikc.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类
 *
 */
public class JDBCUtils {
	// c3p0 连接池
	private static DataSource dataSource = new ComboPooledDataSource();

	// 返回连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	// 自己需要控制事务，通过该方法获得连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// 生成用户编号 UUID
	public static String generateCustomerId() {
		String uuid = UUID.randomUUID().toString();
		int hashcode = Math.abs(uuid.hashCode());
		return "customer_" + hashcode;
	}

	public static String generateUserId() {
		String uuid = UUID.randomUUID().toString();
		int hashcode = Math.abs(uuid.hashCode());
		return "user_" + hashcode;
	}


}
