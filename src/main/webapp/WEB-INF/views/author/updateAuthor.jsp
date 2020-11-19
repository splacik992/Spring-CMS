<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Author</h1>
<form:form method="post" modelAttribute="showAuthor">
    Name:
    <form:input path="firstName" value="${showAuthor.firstName}"/><br/>
    Description:
    <form:input path="lastName" value="${showAuthor.lastName}"/><br/>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
