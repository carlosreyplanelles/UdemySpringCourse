<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">
<title>Add Customer Form</title>
</head>
<body>

<h1>Create Customer </h1>
	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST">
		<div class="form-group row">
			<label class="col-lg-2">First Name:</label>
			<form:input class="form-control col-lg-2" path="firstName" />
		</div>
		<div class="form-group row">
			<label class="col-lg-2">Last Name:</label>
			<form:input class="form-control col-lg-2" path="lastName" />
		</div>
		<div class="form-group row">
			<label class="col-lg-2">Email:</label>
			<form:input class="form-control col-lg-2 " path="email" />
		</div>
		<div class="row col-lg-4">
		<input type="submit" class="btn btn-primary col-lg-5" value="Save"/>
		<a href="${pageContext.request.contextPath}/customer/" class="btn btn-secondary col-lg-5 offset-lg-2">Cancel</a>
		</div>
		
	</form:form>


</body>
</html>