<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>
	
	<p>Student ${student.firstName} ${student.lastName} confirmed.<p>
	<p>Country: ${student.country}</p>
	<p>Favorite Language: ${student.favoriteLanguage}</p>
	<p>Operating Systems:</p>
	<ul>
		<c:forEach var="operatingSystem" items="${student.operatingSystems}">
			<li>${operatingSystem}</li>
		</c:forEach>
	</ul>
</body>
</html>