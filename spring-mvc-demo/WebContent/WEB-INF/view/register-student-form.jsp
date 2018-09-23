<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<title>Student registration</title>
	<form:form action="processForm" modelAttribute="student">
		<div>
			<label>First Name: </label>
			<form:input path="firstName"/>
		</div>
		<div>
			<label>Last Name: </label>
			<form:input path="lastName"/>
		</div>
		<div>
			<label>Country: </label>
			<form:select path="country"> 
 				<form:options items="${theCountryOptions}" />
			</form:select>
		</div>
		<input type="submit" value="Submit"/>

	</form:form>
</body>
</html>