<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author Page</title>
</head>
<body>
<table>
    <c:forEach items="${allAuthors}" var="aut">
        <tr>
            <th>Name</th>
            <th>Description</th>

        </tr>

        <tr>
            <td>${aut.firstName}</td>
            <td>${aut.lastName}</td>
            <td><a href="/author/update/${aut.id}">Update</a></td>
            <td><a href="/author/delete/${aut.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<form:form method="get" action="/author/add">
    <button type="submit">New Author</button>
</form:form>
<form:form method="get" action="/">
    <button type="submit">Main Page</button>
</form:form>
</body>
</html>
