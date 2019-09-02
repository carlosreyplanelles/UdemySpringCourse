<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 21/08/2019
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>
<h1>SPRING REST DEMO</h1>
<a href="${pageContext.request.contextPath}/test/hello">hello Test</a>
<a href="${pageContext.request.contextPath}/api/students">get All students</a>
</body>
</html>
