
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="newConfirm.jsp" onsubmit="return fun1()">
    用户名：<input type="text" name="username" id="username"><br>
    密码：<input type="password" name="password" id="password"><br>
 link：<input type="text" name="link" id="link"><br>
    角色：<input type="text" name="roles" id="roles"><br>
 uid：<input type="number" name="uid" id="uid"><br>
 <input type="submit" name="submit" value="submit">
 <input type="reset" name="reset" value="reset">
</form>

<script type="application/javascript" language="JavaScript">
    function fun1() {
        let user = document.getElementById('username').value;
        if (user.length < 6 || user.length > 10){
            alert("用户名长度应在6-10之间");
            return false;
        }
        if (!((user.charAt(0) >= 'a' && user.charAt(0) <= 'z') || (user.charAt(0) >= 'A' && user.charAt(0) <= 'Z'))) {
            alert("用户名开头应是字母");
            return false;
        }
        let link = document.getElementById("link").value;
        if (link == null || link === '') {
            alert("link不能为空");
            return false;
        }
        let roles = document.getElementById("roles").value;
        if (roles == null || roles === '') {
            alert("roles不能为空");
            return false;
        }
        let uid = document.getElementById("uid").value;
        if (uid == null || uid === '') {
            alert("uid不能为空");
            return false;
        }
    }
</script>

</body>
</html>
