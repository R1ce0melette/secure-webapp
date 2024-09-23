<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>

<html xmlns:th="http://thymeLeaf.org">
<!-- <html xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity5" xmlns:th="https://www.thymeleaf.org"> -->

<head>
    <title> Home </title>

 <style>
      div {
        width: 2000px;
        overflow: hidden;
        border: 2px solid #ff1100;
        clear: both;
        float: right;
        margin-top:25px;
      }
      p {
      	margin-left:100px;
        margin-bottom: 10px;
      }
      input.right {
        float: right;
      }
    </style>
  
  	<form:form action="${pageContext.request.contextPath}/showMyLoginPage"
			   method="GET">
		<input type="submit" value="Login" class="right"/>
		
	</form:form>	
</head>

<body>

  <h1>Welcome to Secure version of the Vulnerable App!!</h1>

</body>
</html>