package com.qin.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.qin.jdbc.utils.C3P0Utils;

/**
 * 测试DBUtils工具类的增删改操作
 * 
 * @author Never Say Never
 * @date 2016年7月31日
 * @version V1.0
 */
public class TestDBUtils1 {

	/**
	 * 添加所有用户方法
	 */
	@Test
	public void testAddUser() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写SQL语句
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			// 3.为站位符设置值
			Object[] params = { "eee", "1234","xuesheng",5,"xiaosi" };
			// 4.执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id修改用户方法
	 * 
	 */
	@Test
	public void testUpdateUserById() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写SQL语句
			String sql = "update tbl_user set upassword=? where uid=?";
			// 3.为站位符设置值
			Object[] params = { "xxx", 21 };
			// 4.执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id删除用户方法
	 */
	@Test
	public void testDeleteUserById() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写SQL语句
			String sql = "delete from tbl_user where uid=?";
			// 3.为站位符设置值
			Object[] params = {19};
			// 4.执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("删除成功!");
			} else {
				System.out.println("删除失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
