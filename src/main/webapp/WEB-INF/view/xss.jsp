<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<script type="text/javascript">
    function validatePayload() {
        var payload = document.getElementById("payload")[0].value;
        var errorMessage = "";
		console.log(payload);
        //Payload cannot be null or empty
        if (!payload || payload.trim() === "") {
            errorMessage = "Payload cannot be empty.";
            console.log(errorMessage);
        }
        
        //Payload size must be bigger than 3
        else if (payload.length < 3) {
            errorMessage = "Payload size must be bigger than 3";
            console.log(errorMessage);
        }

        // Whitelist characters
        else if (!/^[a-zA-Z!@#*]+$/.test(payload)) {
            errorMessage = "Payload have bad characters.";
            console.log(errorMessage);
        }
        if (errorMessage) {
        	document.getElementById("errors").innerText = errorMessage;
            return false; // Prevent form submission
        }
        return true;
    }
</script>
<title>Secure Exam Generation</title>
</head>
<body>

	<h2>XSS page - add an input form and display text</h2>
<form:form modelAttribute="payload" method="get" accept-charset="utf-8" action="${pageContext.request.contextPath}/doxss" onsubmit="return validatePayload();">
    <input type="text" name="payload">
    <form:errors name="errors" cssClass="error" />
    <input type="submit" value="Submit">
</form:form>
 <div id="errors" class="error"></div>
	<hr>
<p>${fn:escapeXml(payload)}</p>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>

</body>
</html>
>
