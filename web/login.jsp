<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/7/23
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<hr>
<form action="LoginServlet" method="POST">
    用户名：<input type="text" name="username">
    <br>
    密码：  <input type="password" name="password" /><br>
    <button type="reset">重置</button>
    <input type="submit" value="登录" />
</form>
<br>
<br>
</body>
</html>
