<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Author</title>
</head>
<body>

<h1>New Author</h1>
<form:form method="post" modelAttribute="newAuthor">
    Name:
    <form:input path="firstName"/>
    <form:errors path="firstName"/><br/>

    Description:
    <form:input path="lastName"/><br/>
    <form:errors path="lastName"/>
    <input type="submit" value="Submit">
</form:form>
<form:form method="get" action="/author/all">
    <button type="submit">Cancel</button>
</form:form>

</body>
</html>