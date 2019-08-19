<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
	<title>Maven-security-demo</title>
</head>
<body>
<h1>WELCOME TO SPRING SECURITY!</h1>
<div>
	Username: <security:authentication property="principal.username"/>
	Roles: <security:authentication property="principal.authorities"/>
</div>
<form:form action="${pageContext.request.contextPath}/logout"
		   method="POST">
	<input type="submit" value="Logout"/>
</form:form>
</body>
</html>