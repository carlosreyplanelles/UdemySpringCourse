<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student registration</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
		<fieldset>
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
			<label>Favorite Programming Language: </label>
				<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
		</div>
		<div>
			<label>Operative System:</label>
				<form:checkboxes path="operatingSystems" items="${student.operatingSystemOptions}"/>
		</div>	
			
		</fieldset>
		<input type="submit" value="Submit"/>

	</form:form>
</body>
</html>