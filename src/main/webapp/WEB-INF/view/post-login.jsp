<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>Secure App</h2>

<!-- Add a link to point to XSS -->
<p>
	<a href ="${pageContext.request.contextPath}/xss"> XSS </a>
</p>

<!-- Add a link to point to sqli -->
<p>
	<a href ="${pageContext.request.contextPath}/sqli"> SQL Injection </a>
</p>

<!-- Add a link to point to file upload -->
<p>
	<a href ="${pageContext.request.contextPath}/fileUpload"> File Upload </a>
</p>
<!-- Add a link to point to CSRF -->
<p>
	<a href ="${pageContext.request.contextPath}/csrf"> CSRF </a>
</p>
<!-- Add a link to point to LFI -->
<p>
	<a href ="${pageContext.request.contextPath}/DA"> DA </a>
</p>
<!-- Add a link to point to SSRF -->
<p>
	<a href ="${pageContext.request.contextPath}/ssrf"> SSRF </a>
</p>


<!-- Add a logout form -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout"/>
		
	</form:form>	
</body>
</html>