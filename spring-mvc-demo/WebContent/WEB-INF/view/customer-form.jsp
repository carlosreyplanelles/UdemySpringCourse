<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
 <head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/general.css">
</head> 
	<head>
		<title>Customer Registration</title>
	</head>
	<body>
		<i>Fill out the form. Asterisk (*) means required</i>
		<form:form action="processForm" modelAttribute="customer">
			<fieldset>
				<div>
					<label>First Name: </label>
					<form:input path="firstName"/>
				</div>
				<div>
					<label>Last Name(*): </label>
					<form:input path="lastName"/>
					<form:errors path="lastName" cssClass="error"/>
				</div>
				<div>
					<label>FreePasses: </label>
					<form:input path="freePasses"/>
					<form:errors path="freePasses" cssClass="error"/>
				</div> 
				<input type="submit" value="Submit"/>
			</fieldset>
		</form:form>
		
	</body>
</html>