<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>����ҳ��</title>
</head>
<body>
	<form action="" method="post" name="form">
	�����ǵ��Ϲ�̨����ѡ��Ҫ����ĵ��ϣ�<br />
	<input type="checkbox" name="sec" value="����" />����<br />
	<input type="checkbox" name="sec" value="ţ��" />ţ��<br />
	<input type="checkbox" name="sec" value="����" />����<br />
	<input type="submit" name="gouwu" value="�ύ">
	<br />
	<br />
	<a href="shocart.jsp">�����</a>
	<a href="lookShopCart.jsp">�鿴���ﳵ��</a>
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