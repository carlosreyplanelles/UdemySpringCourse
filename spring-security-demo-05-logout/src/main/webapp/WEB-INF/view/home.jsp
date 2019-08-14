<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Maven-security-demo</title>
</head>
<body>
	<h1>WELCOME TO SPRING SECURITY!</h1>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>