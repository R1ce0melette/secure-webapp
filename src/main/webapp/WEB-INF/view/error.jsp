<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied Page</title>
</head>
<body>

<h2>Generic Error page</h2>
<p>${err}</p>>
<p>${details}</p>>
<a href= "${pageContext.request.contextPath}/"> Back to Home Page </a>

</body>
</html>