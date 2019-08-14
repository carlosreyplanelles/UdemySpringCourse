<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Custom Login Page</title>
</head>
<body>
</body>
<h1>Custom Login Page</h1>
<form:form action="${pageContext.request.contextPath}/authenticateUser"
	method="POST">
	<c:if test="${param.error != null}">
		<label>ERROR: Invalid Username/Password</label>
	</c:if>
	<div>
		<label>Username:</label><input type="text" name="username" />
	</div>
	<div>
		<label>Password:</label><input type="password" name="password" />
	</div>
	<input type="submit" value="Login" />
</form:form>
</html>
