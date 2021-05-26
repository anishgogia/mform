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
 <form:form action="otp" method="post" modelAttribute="signup">

First Name:<form:input path="fname" />

Last Name:<form:input path="lname" /><br>

Age:<form:input  path="age" /><br>
Male: <form:radiobutton path="gender" value="M"/>
Female: <form:radiobutton path="gender" value="F"/><br>
Address:<form:input path="add" /><br>
Password:<form:password path="pin" /><br>

Email Address(*):<form:input  path="eid" /><br>
<form:errors path="eid" /><br>
<form:button>Submit</form:button>



</form:form>

</body>
</html>