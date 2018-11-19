package com.qin.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.qin.domain.Students;
import com.qin.jdbc.utils.C3P0Utils;

/**
 * ����DBUtils��ѯ����
 * 
 * @author Never Say Never
 * @date 2016��7��31��
 * @version V1.0
 */
public class TestDBUtils2 {

	/*
	 * ��ѯ�����û�����
	 */
	@Test
	public void testQueryAll() {
		try {
			// 1.��ȡ������queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дsql���
			String sql = "select * from students";
			// 3.ִ�в�ѯ����
			List<Students> users = qr.query(sql, new BeanListHandler<Students>(Students.class));
			// 4.�Խ�������Ͻ��б���
			for (Students user : users) {
				System.out.println(user.getUsername() + " : " + user.getPwd());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ����id��ѯ�û�����
	 */
	@Test
	public void testQueryUserById() {
		try {
			// 1.��ȡ������queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дsql���
			String sql = "select * from tbl_user where uid=?";
			//3.Ϊռλ������ֵ
			Object[] params = {21};
			// 4.ִ�в�ѯ����
			Students user = qr.query(sql, new BeanHandler<Students>(Students.class), params);
			System.out.println(user.getUsername() + " : " + user.getPwd());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ���������û����ܸ���
	 */
	@Test
	public void testQueryCount() {
		try {
			// 1.��ȡ������queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дsql���
			String sql = "select count(*) from tbl_user";
			// 4.ִ�в�ѯ����
			Long count = (Long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ��ѯ�����û�����
	 */
	@Test
	public void testQueryAll1() {
		try {
			// 1.��ȡ������queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дsql���
			String sql = "select * from tbl_user";
			// 3.ִ�в�ѯ����
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
			// 4.�Խ�������Ͻ��б���
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ��ѯ�����û�����
	 */
	@Test
	public void testQueryAll2() {
		try {
			// 1.��ȡ������queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дsql���
			String sql = "select * from tbl_user";
			// 3.ִ�в�ѯ����
			List<Object> list = qr.query(sql, new ColumnListHandler("username"));
			// 4.�Խ�������Ͻ��б���
			for (Object object : list) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
