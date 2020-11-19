<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>
<h1>Update Category</h1>
<form:form method="post" modelAttribute="updateCategory">
    Name:
    <form:input path="name" value="${updateCategory.name}"/><br/>
    Description:
    <form:input path="description" value="${updateCategory.description}"/><br/>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
