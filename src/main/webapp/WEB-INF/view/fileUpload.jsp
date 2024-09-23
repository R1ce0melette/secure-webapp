<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script>
function validateFileUpload() {
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];

    if (!file) {
        alert("Please select a file.");
        return false;
    }

    // Allowed file extensions
    var allowedExtensions = /(\.txt|\.jpg|\.png)$/i;
    
    // Validate file extension
    if (!allowedExtensions.exec(fileInput.value)) {
        alert("Invalid file type. Only .txt, .jpg, and .png files are allowed.");
        fileInput.value = '';
        return false;
    }

    // Validate file size
    var maxSizeInBytes = 4 * 1024 * 1024; // 4MB
    if (file.size > maxSizeInBytes) {
        alert("File size exceeds 4MB. Please upload a smaller file.");
        fileInput.value = '';
        return false;
    }

    return true; // Proceed with the upload
}
</script>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>

	<h2>File upload - Restricted to only txt, png and jpg</h2>
	<form:form action="${pageContext.request.contextPath}/fileUpload"
		method="POST" enctype="multipart/form-data" onsubmit="return validateFileUpload()">
		<label>Select a file to upload:</label>
		<input type="file" name="file" />
		<button type="submit">Go</button>
	</form:form>
	<br>
	<b>${message}</b>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>
</body>
</html>