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
<table>
    <c:forEach items="${articleList}" var="articles">
        <tr>
            <th>Title</th>
            <th>Date</th>
            <th>Content</th>
        </tr>

        <tr>
            <td>${articles.title}</td>
            <td>${articles.createdOn.format(formaterDate)}</td>
            <td>${articles.content}</td>
        </tr>
    </c:forEach>
</table>

<form:form method="get" action="/article/add">
    <button type="submit">New Article</button>
</form:form>
<br/>
<h3><a href="/category/all">Categories</a></h3>
<h3><a href="/author/all">Authors</a></h3>

</body>
</html>
