<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</body>
</html>
