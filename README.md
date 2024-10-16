<h1>A 'secure' version of the vulnerable web application</h1>
Fixed all the common vulnerabilities:
- XSS: Spring Hibernate input validator, client side validation using JS. <br>
- SQL injection: Query construction using Hibernate ORM, stored procedure. <br>
- Unrestricted file upload: Limit file upload using Spring Security configuration, input validation on client side with JS <br>
- CSRF: built-in Spring security CSRF token / verify referer header (make sure all request coming from the same domain) && hidden token generated randomly using JSessionID <br>
- SSRF: Spring Hibernate input validator, client side validation using JS, whitelist domain on array (harcoded tho) <br>
Implemented custom error handling page and output error message to log file on local machine. <br>
