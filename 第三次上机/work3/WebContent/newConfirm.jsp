
<%@page import="java.sql.Time"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.qin.jdbc.utils.C3P0Utils"%>

<%@ page import="java.sql.SQLException"%>

<%@ page import="org.apache.commons.dbutils.QueryRunner"%>
<%
    request.setCharacterEncoding("UTF-8");
    String username =  request.getParameter("username");
    try {
        username.trim();
    }catch (Exception e){
        throw new Exception("请输入username");
    }
    String password = request.getParameter("password");
    try {
        password.trim();
    }catch (Exception e) {
        throw new Exception("请输入password");
    }
    String link = request.getParameter("link");
    String roles = request.getParameter("roles");
    String uid = request.getParameter("uid");
    
    
	try {
		// 1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		// 2.编写SQL语句
//		insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
		String sql = "insert into students values(Null,?,?,?,?,?);";
		// 3.为站位符设置值
		Object[] params = { link, password,roles,uid,username };
		// 4.执行添加操作
		int rows = qr.update(sql, params);
		if (rows > 0) {
			System.out.println("新建学生成功!");
			out.println("新建学生成功!");
			//跳转到登录页面
			//response.sendRedirect(request.getContextPath()+"/list");
			response.setHeader("refresh","5;URL= ResultServlet");
		} else {
			System.out.println("添加失败!");
			out.println("添加失败!");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


%>
<html>
<head>
    <title>Post</title>
</head>
<body>
<ul>
    <li>用户名：<%=username%></li>
    <li>密码：<%=password%></li>
    <li>link：<%=link%></li>
    <li>角色：<%=roles%></li>
    <li>uid：<%=uid%></li>

</ul>
</body>
</html>
