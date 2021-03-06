<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Articles</h1>
<table border="3">

        <tr>
            <th>Title</th>
            <th>Date</th>
            <th>Content</th>

        </tr>
    <c:forEach items="${articleList}" var="articles">
        <tr>
            <td>${articles.title}</td>
            <td>${articles.createdOn.format(formaterDate)}</td>
            <td>${articles.content}</td>
            <td><a href="/article/update/${articles.id}">Update</a></td>
            <td><a href="/article/delete/${articles.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<form:form method="get" action="/article/add">
    <button type="submit" style="background-color: bisque">New Article</button>
</form:form>
<br/>
<form:form method="get" action="/category/all">
    <button type="submit" style="background-color: chocolate">Category</button>
</form:form>
<form:form method="get" action="/author/all">
    <button type="submit" style="background-color: chocolate">Author</button>
</form:form>


</body>
</html>
