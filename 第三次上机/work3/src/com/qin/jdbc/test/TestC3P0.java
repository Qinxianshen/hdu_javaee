package com.qin.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import com.qin.jdbc.utils.C3P0Utils;
import com.qin.jdbc.utils.JDBCUtils_V3;

public class TestC3P0 {
	@Test
	public void testAddUser1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 2.�ӳ����л�ȡ����
			conn = C3P0Utils.getConnection();
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "����3");
			pstmt.setString(2, "����3");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("��ӳɹ�!");
			} else {
				System.out.println("���ʧ��!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}

	@Test
	public void testAddUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1.�����Զ������ӳض���
		ComboPooledDataSource dataSource = new ComboPooledDataSource();// ����Ĭ�ϵ�����
		// ComboPooledDataSource dataSource = new
		// ComboPooledDataSource("itheima");//���������Ƶ�����
		try {
			// 2.�ӳ����л�ȡ����
			conn = dataSource.getConnection();
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "����3");
			pstmt.setString(2, "����3");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("��ӳɹ�!");
			} else {
				System.out.println("���ʧ��!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}
}
