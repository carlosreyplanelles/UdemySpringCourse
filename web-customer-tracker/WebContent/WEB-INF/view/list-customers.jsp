<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<form:form action="search" method="GET">
		<div class="active-cyan-3 active-cyan-4 mb-4 row">
			<div class="col-md-6">
				<input class="form-control" type="text" placeholder="Search"
					name="firstName" aria-label="Search">
			</div>
			<div class="col-md-3">
				<input type="submit" value="Search" class="btn btn-primary btn" />
			</div>
		</div>
	</form:form>

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
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><a href="${updateLink}" class="btn btn-primary">Update</a>
						<a
						onclick="if(!(confirm('Do you want to delete ${customer.firstName} ${customer.lastName }?'))) return false"
						href="${deleteLink}" class="btn btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-primary btn-block btn-lg"
		value="Add Customer"
		onclick="window.location.href='showAddCustomerForm';return false;" />
</body>
</html>