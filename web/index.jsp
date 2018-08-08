<%@ page import="user.Admin" %>
<%@ page import="JDBC.Books" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>登录成功</h1><br>

<%
    Admin admin = (Admin) request.getSession().getAttribute("ADMIN");
    List<Books> book = (List<Books>)request.getSession().getAttribute("BOOK");
%>
<div >
    用户： <%=admin.getName()%><br>
    <c:forEach items="<%=book%>" var="books" >
        ID:${books.id} 书名： ${books.name}作者：${books.author}书价：${books.price}
        <a href="/DeleteBookServlet?id=${books.id}">删除图书</a><br>
    </c:forEach>
    <a href="/update_book.jsp">修改图书</a>
    <a href="/insert_book.jsp">增加图书</a>
    <a href="/search_book.jsp">查找图书</a>
</div>
</body>
</html>
