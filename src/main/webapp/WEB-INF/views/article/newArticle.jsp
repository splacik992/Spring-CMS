<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>New Article</h1>
<form:form method="post" modelAttribute="newCategory">
    Name:
    <form:input path="name"/><br/>
    Description:
    <form:input path="description"/><br/>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
