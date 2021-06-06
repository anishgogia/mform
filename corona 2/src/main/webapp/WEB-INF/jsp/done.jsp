<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
hello sir
<c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form:form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
            <input type="submit" value="Logout"/>
    </form:form>
   
    
</body>
</html>