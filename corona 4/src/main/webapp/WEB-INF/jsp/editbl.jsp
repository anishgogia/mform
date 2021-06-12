<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <body>
    <div align="center">
        <h1>New/Edit Contact</h1>
        <form:form action="" method="post" modelAttribute="usere">
        <table>
            <form:hidden path="phn"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"  /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phn" /></td>
            </tr>
            <tr>
                <td>Blood:</td>
                <td><form:input path="blood" /></td>
            </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>