<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>查看购物车商品页面</title>
</head>
<body>
	<%
	
	Enumeration enumsec= session.getAttributeNames();
 	out.println("<br>你选择的结果是：<br>");
 	while (enumsec.hasMoreElements()) {
 		String ser=(String)enumsec.nextElement();
 		String scr=(String)session.getAttribute(ser);
 		out.println("                    " + scr + "<br>");
 		session.removeAttribute(ser);

 	}
 	%>
</body>