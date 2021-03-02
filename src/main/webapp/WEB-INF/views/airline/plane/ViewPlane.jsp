<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head >
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	
    <title>AirlineManagementSystem</title>
  </head>
  <body style="background-image: url('${pageContext.request.contextPath}/static/images/kk.jpg');">
    
 
      <div class="wrapper" >
         
            <nav >
               <div class="menu-icon"  >
                  <i class="fa fa-bars fa-2x"></i>
               </div>
               <div class="logo">
                  A<small style="font-size: 13px">irline </small>M<small style="font-size: 13px">anagement </small>S<small style="font-size: 13px">ystem</small>
               </div>
               <div class="menu">
                  <ul>
                     <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                     
                      <c:choose>
				  <c:when test="${user eq null and airline eq null}">
					<li><a href="${pageContext.request.contextPath}/UserLogin">User Login</a></li>
                     <li><a href="${pageContext.request.contextPath}/AirlineLogin">Airline Login</a></li>
                     <li><a href="${pageContext.request.contextPath}/AdminLogin">Admin</a></li>		    
				  </c:when>
				  		
				  <c:when test="${airline eq null}">
					<li><a href="${pageContext.request.contextPath}/UserDashboard">Your Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/UserLogout">Log Out</a></li>
                     		    
				  </c:when>
				  <c:otherwise>
				    <li><a href="${pageContext.request.contextPath}/AirlineDashboard">Your Dashboard</a></li>
				    <li><a href="${pageContext.request.contextPath}/AirlineLogout">Log Out</a></li>
				  </c:otherwise>
				</c:choose>
                     
                     <li><a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
                  </ul>
               </div>
               
		     
				
            </nav></div>
            
            <p> <br><br><br><br></p>
            <div class="Container" align="center">
		<div class="jumbotron" align="center" style="width: 80% ;background-color: white opacity: 0.2; "> 
			<table class="table" style="align:center" >
			  <thead class="thead-dark">
			    <tr align="center">
			      
			      <th scope="col">PlANE ID</th>
			      <th scope="col">PLANE NAME</th>
			      <th scope="col">AIRLINE</th>
			      <th scope="col">CAPACITY</th>
			      <th scope="col">UPDATE</th>
			      <th scope="col">DELETE</th>
			    </tr>
			  </thead>
			  <tbody>
			   <c:forEach begin="0" end="${plane_count}" var="plane" items="${planes}" >
			  
			    <tr align="center">
			      <td align="center"><p style="font-size: 30px;">${plane.id}</p> </td>
			     
			      <td align="center"><strong style="font-size: 30px; color: purple">${plane.name}</strong></td>
			      <td align="center"> <strong style="font-size: 30px; cstronglor: green" >${plane.airline}</strong></td>

			      <td align="center"><p style="font-size: 30px;">${plane.capacity}</p></td>
			      
			      <td><a href="${pageContext.request.contextPath}/UpdatePlaneDetail/${plane.id}"><svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
				  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
				</svg></a>
				
				
				
				</td>
			   
			      <td><a href="${pageContext.request.contextPath}/deletePlane/${plane.id}"><svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="red" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
					</svg></a></td>

			    </tr>
			    
			  </c:forEach>
			   </tbody>
			</table>
		</div>
	</div>
       
         
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
   

    
    
    
    
    

  </body>
</html>


