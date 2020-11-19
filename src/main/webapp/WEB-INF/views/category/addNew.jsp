<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addNewCategory</title>
</head>

<body>
<h1>New Category</h1>
<form:form method="post" modelAttribute="newCategory">
    Name:
    <form:input path="name"/><br/>
    Description:
    <form:input path="description"/><br/>
    <input type="submit" value="Submit">
</form:form>
<form:form method="get" action="/category/all">
    <button type="submit">Cancel</button>
</form:form>
</body>
</html>
