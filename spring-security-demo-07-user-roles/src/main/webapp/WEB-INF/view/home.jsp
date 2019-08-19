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
<security:authorize access="hasRole('MANAGER')">
    <div>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip meeting (Only for managers)</a>
    </div>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
    <div>
        <a href="${pageContext.request.contextPath}/systems">IT Systems meeting (only for admins)</a>
    </div>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>