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
 <meta http-equiv="Pragma" content="no-cache">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resources/css/done.css">
<title>Insert title here</title>

<script>
// When the user clicks on <div>, open the popup
function openPopup(firstmodel {
	
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}
</script>
</head>
<body>
<%@include file="nav.jsp" %>
<nav id="sidenav">
        
        <ul>
            <h1 id="admin">DASHBOARD</h1>
            <li class="table2"><a href="corona.html">Requests </a></li>
            <li class="table2"><a href="facebook.com">Approved Requests</a></li>
            <li class="table2"><a href="done">Blood</a></li>
            
            <c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form:form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
            <input type="submit" value="Logout" cssClass="logout"/>
    </form:form>
            
           
   
        </ul>
    </nav>
<!--<c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form:form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
            <input type="submit" value="Logout"/>
    </form:form>-->
    
  <h3 class="heading">List of blood donors</h3>
    <br><br>
    <table class="table" style="width: auto;">
        <tr>

            <th>Name</th>
            <th>Contact</th>
            <th>Blood Group</th>
           
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <c:forEach items="${bloodlist}" var="firstModel">
            <tbody>
                <tr>

                    <td width="60">${firstModel.name}</td>
                    <td width="60">${firstModel.phone}</td>
                    <td width="60">${firstModel.blood}</td>
                   
                    <td width="60"><a href="delete${firstModel.phone}"><img id=delete src="resources/img/decline.png" alt=""></a>
                    <%-- <td width="60"><a href="update/${bloodd.phn}"><img id=update src="resources/img/update.png" alt=""></a>--%>
                    
                     <td width="60"><button class="btn" onClick="openPopup(this)" data-target="#mymodal" data-toggle="modal"><img id=update src="resources/img/update.png" alt=""></button>
        


        <br><br>
        <div class="modal" id="mymodal">

            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <br><br>
                        <h4 class="heading2">Please fill the information below</h4>
                        <button class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form:form>
                        
                            <div class="form-group">
                                <input class="un " name="name" type="text" value= ${this.name}>
                                <br>
                                <input class="un " type="text" name="mobile" value= ${this.phone}>
                                <br>
                                 <input class="un " type="text" name="blood" value= ${this.blood}>
                              
                                <button type="submit" class="btn2"><a href="update/${firstModel.phone}">Submit</a></button>
                            </div>
                        </form:form>

                    </div>

                </div>
            </div>
        </div>

    </div>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
  </body>
</html>