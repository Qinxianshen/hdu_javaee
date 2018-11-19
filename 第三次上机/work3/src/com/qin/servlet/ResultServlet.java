package com.qin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qin.jdbc.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;
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
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 1.获取核心类queryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写sql语句
			String sql = "select * from students";
			// 3.执行查询操作
			List<Students> users = qr.query(sql, new BeanListHandler<Students>(Students.class));
			// 4.对结果集集合进行遍历
			response.getWriter().println("<table border='1'>");

			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+"link"+"</td>");
			response.getWriter().println("<td>"+"id"+"</td>");
			response.getWriter().println("<td>"+"password"+"</td>");
			response.getWriter().println("<td>"+"roles"+"</td>");
			response.getWriter().println("<td>"+"username"+"</td>");
			response.getWriter().println("</tr>");
			for (Students user : users) {
				System.out.println(user.getUsername() + " : " + user.getPwd());
				response.getWriter().println("<tr>");
				response.getWriter().println("<td>"+user.getLink()+"</td>");
				response.getWriter().println("<td>"+user.getId()+"</td>");
				response.getWriter().println("<td>"+user.getPwd()+"</td>");
				response.getWriter().println("<td>"+user.getRoles()+"</td>");
				response.getWriter().println("<td>"+user.getUsername()+"</td>");
				response.getWriter().println("</tr>");
			}
			response.getWriter().println("</table>");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
