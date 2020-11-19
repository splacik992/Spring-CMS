<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1>Categories</h1>
</head>
<body>

<table>
    <c:forEach items="${categoriesList}" var="categories">
        <tr>
            <th>Name</th>
            <th>Description</th>

        </tr>

        <tr>
            <td>${categories.name}</td>
            <td>${categories.description}</td>
            <td><a href="/category/update/${categories.id}">Update</a></td>
            <td><a href="/category/delete/${categories.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<form:form method="get" action="/category/add">
    <button type="submit">New Category</button>
</form:form>
</body>
</html>
