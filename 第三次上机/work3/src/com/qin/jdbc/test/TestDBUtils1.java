package com.qin.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.qin.jdbc.utils.C3P0Utils;

/**
 * ����DBUtils���������ɾ�Ĳ���
 * 
 * @author Never Say Never
 * @date 2016��7��31��
 * @version V1.0
 */
public class TestDBUtils1 {

	/**
	 * ��������û�����
	 */
	@Test
	public void testAddUser() {
		try {
			// 1.����������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дSQL���
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			// 3.Ϊվλ������ֵ
			Object[] params = { "eee", "1234","xuesheng",5,"xiaosi" };
			// 4.ִ����Ӳ���
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("��ӳɹ�!");
			} else {
				System.out.println("���ʧ��!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����id�޸��û�����
	 * 
	 */
	@Test
	public void testUpdateUserById() {
		try {
			// 1.����������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дSQL���
			String sql = "update tbl_user set upassword=? where uid=?";
			// 3.Ϊվλ������ֵ
			Object[] params = { "xxx", 21 };
			// 4.ִ����Ӳ���
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("�޸ĳɹ�!");
			} else {
				System.out.println("�޸�ʧ��!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����idɾ���û�����
	 */
	@Test
	public void testDeleteUserById() {
		try {
			// 1.����������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.��дSQL���
			String sql = "delete from tbl_user where uid=?";
			// 3.Ϊվλ������ֵ
			Object[] params = {19};
			// 4.ִ����Ӳ���
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("ɾ���ɹ�!");
			} else {
				System.out.println("ɾ��ʧ��!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
