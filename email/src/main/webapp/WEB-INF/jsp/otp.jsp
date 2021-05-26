<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
 <div>

</div>
 
<body>
<h1>Welcome Please Enter  details here</h1>
  <form:form action="verify" method="post" modelAttribute="signup">

OTP:<form:input path="one" />

<form:button>Submit</form:button>



</form:form>
</body>
</html>