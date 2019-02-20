<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<head>
		<meta charset="ISO-8859-1">
		<title>Customers list</title>
	</head>
	<body>
		<div id = "wrapper">
			<div id="header">
			</div>
			<div id="container">
				<div id="content">
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
						</tr>
						<c:forEach var="customer" items="${customers}">
							<tr>
								<td>${customer.firstName}</td>
								<td>${customer.lastName}</td>
								<td>${customer.email}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>		
		</div>
	</body>
</html>