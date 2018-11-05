<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>¹ºÎïÒ³Ãæ</title>
</head>
<body>
	<form action="" method="post" name="form">
	ÕâÀïÊÇµ÷ÁÏ¹ñÌ¨£¬ÇëÑ¡ÔñÒª¹ºÂòµÄµ÷ÁÏ£º<br />
	<input type="checkbox" name="sec" value="ÀºÇò" />ÀºÇò<br />
	<input type="checkbox" name="sec" value="×ãÇò" />×ãÇò<br />
	<input type="checkbox" name="sec" value="ÅÅÇò" />ÅÅÇò<br />
	<input type="submit" name="gouwu" value="Ìá½»">
	<br />
	<br />
	<a href="shopcart2.jsp">Âòµã±ðµÄ</a>
	<a href="lookShopCart.jsp">²é¿´¹ºÎï³µ£¡</a>
	<%
	request.setCharacterEncoding("GB2312");
	String sec[] = request.getParameterValues("sec");
	if (sec!=null && sec.length!= 0) {
	for (int i=0;i<sec.length;i++) {
		session.setAttribute(sec[i],sec[i]);
	}
	}	
			%>
</body>
</html>