<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pali
  Date: 19.11.2020
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Article</title>
</head>
<body>
<form:form method="post" modelAttribute="updateArticle">
    Name:
    <form:input path="title" value="${updateArticle.title}"/><br/>
    Description:
    <form:input path="content" value="${updateArticle.content}"/><br/>
    Author:
    <form:select path="author" items="${authors}"
                 itemLabel="firstName" itemValue="id"/><br/>
    Category:
    <form:select path="category" items="${categories}"
                 multiple="false" itemLabel="name" itemValue="id"/><br/>
    <input type="submit" value="ZAPISZ!"/>
</form:form>
<form:form method="get" action="/">
    <button type="submit">Cancel</button>
</form:form>
</body>
</html>
