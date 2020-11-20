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
<form:form method="post" modelAttribute="newArticle">
    Name:
    <form:input path="title"/>
    <form:errors path="title"/>
    <br/>
    Description:
    <form:input path="content"/>
    <form:errors path="content"/>
    <br/>
    Author:
    <form:select path="author" items="${authors}"
                 itemLabel="firstName" itemValue="id"/><br/>
    Category:
    <form:select path="category" items="${categories}"
                 multiple="true" itemLabel="name" itemValue="id"/><br/>
    <form:errors path="category"/>
    <input type="submit" value="ZAPISZ!"/>
</form:form>
<form:form method="get" action="/">
    <button type="submit">Cancel</button>
</form:form>
</body>
</html>
