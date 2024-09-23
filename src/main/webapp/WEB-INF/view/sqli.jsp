<html>
<head>

	<title>Secure Exam Generation </title>
</head>
<body>

	<h2> SQLi - display database entries </h2>
	<form method="get" action="${pageContext.request.contextPath}/postsqli">
		<input type="text" id="username" name="username" placeholder="username">
		<input type="text" id="password" name="password" placeholder="password"><br>
		<br>
		<input type="submit" value="Submit">
	</form>
	<h3>${username}</h3>
	<hr>
	
	<a href ="${pageContext.request.contextPath}/post-login"> Back to Home Page </a> 
	
</body>
</html>