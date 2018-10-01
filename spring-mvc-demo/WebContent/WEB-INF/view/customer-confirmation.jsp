<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer Confirmation</title>
</head>
<body>
	
	<p>Customer ${customer.firstName} ${customer.lastName} confirmed.<p>
 	<p>Free Passes: ${customer.freePasses}<p>
 	<p>Postal Code: ${customer.postalCode}<p>
 	<p>Course Code: ${customer.courseCode}<p>
 </body>
</html>