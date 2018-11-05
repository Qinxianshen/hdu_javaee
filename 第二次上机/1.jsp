<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 

if(application.getAttribute("count")==null){ 
application.setAttribute("count", new Integer(0)); 
}  
Integer count = (Integer)application.getAttribute("count");  
application.setAttribute("count",new Integer(count.intValue()+1)); 
%> 
<h2> 
<!-- 输出累加后的count参数对应的值 --> 
你是第 <font color="#ff0000"><%=application.getAttribute("count") %></font>个访问本网页的访客
</h2> 
</body>
</html>