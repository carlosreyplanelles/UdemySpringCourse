<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">
<title>Customers list</title>
</head>
<body>
	<h1>Customers</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${customers}">
				<c:url var="updateLink" value="/customer/updateForm">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><a href="${updateLink}" class="btn btn-primary btn-sm">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-primary btn-block btn-lg"
		value="Add Customer"
		onclick="window.location.href='showAddCustomerForm';return false;" />
</body>
</html>