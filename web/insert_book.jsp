<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/7/25
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增图书</title>
</head>
<body>
<h1>新增图书</h1><br>
<hr>
<form action="AddBookServlet" method="GET">
    ID:<input type="text" name="id"><br>
    书名：<input type="text" name="name"><br>
    作者：<input type="text" name="author"><br>
    价格：<input type="text" name="price"><br>
    <input type="submit" value="确定" />
    <a href="/index.jsp">返回首页</a>
</form>
</body>
</html>
