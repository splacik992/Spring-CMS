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
    <title>Title</title>
</head>
<body>

<h1>New Author</h1>
<form:form method="post" modelAttribute="newAuthor">
    Name:
    <form:input path="firstName"/><br/>
    Description:
    <form:input path="lastName"/><br/>
    <input type="submit" value="Zapisz">
</form:form>
<form:form method="get" action="/author/all">
    <button type="submit" >Wróć</button>
</form:form>

</body>
</html>