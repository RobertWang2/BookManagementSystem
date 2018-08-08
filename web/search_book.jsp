<%@ page import="model.SearchBook" %>
<%@ page import="JDBC.Books" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Books> book = (List<Books>)request.getSession().getAttribute("SearchBook");
%>
<html>
<head>
    <title>查找图书</title>
</head>
<body>
<form action="SearchBookServlet" method="GET">
    请输入书名查询:<input type="text" name="whichbook">
    <input type="submit" value="搜索" />
    <a href="/index.jsp">返回首页</a>
</form>
<div>
    <c:forEach items="<%=book%>" var="books" >
        ID:${books.id} 书名： ${books.name}作者：${books.author}书价：${books.price}
        <a href="/DeleteBookServlet?id=${books.id}">删除图书</a><br>
    </c:forEach>
</div>
</body>
</html>
