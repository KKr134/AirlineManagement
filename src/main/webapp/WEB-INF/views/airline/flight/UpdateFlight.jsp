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

	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
	
    <title>Update Flight</title>
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
					<li><a href="${pageContext.request.contextPath}/BookedTickets">Booked Tickets</a></li>
					<li><a href="" data-toggle="modal" data-target="#modalLoginForm1">Book Ticket</a></li>
					<li><a href="${pageContext.request.contextPath}/UserLogout">Log Out</a></li>
                     		    
				  </c:when>
				  <c:otherwise>
				  <li><a href="${pageContext.request.contextPath}/UpdatePlane">View Planes</a></li>
				    <li><a href="${pageContext.request.contextPath}/AirlineDashboard">Your Dashboard</a></li>
				    <li><a href="${pageContext.request.contextPath}/AirlineLogout">Log Out</a></li>
				  </c:otherwise>
				</c:choose>
                     
                     <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                  </ul>
               </div>
               
		     
				
            </nav></div>
            
		<br> <br><br><br><br>
		
		<div class="Container" align="center" >
		<div class="jumbotron" align="center" style="width: 90%">
			<table class="table" 	>
			  <thead class="thead-dark" align="center">
			    <tr>
			      <th style="font-size: 20px;" scope="col">&ensp;&ensp; Flight ID</th>
			      <th style="font-size: 20px;" scope="col">Plane</th>
			      <th style="font-size: 20px;" scope="col">Flying From</th>
			      <th style="font-size: 20px;" scope="col">Flying To</th>
			      <th style="font-size: 20px;" scope="col">&ensp;Flight day</th>
			      <th style="font-size: 20px;" scope="col">Capacity</th>
			      <th style="font-size: 20px;" scope="col">&ensp;&ensp;Fare</th>
			      <th style="font-size: 20px;" scope="col">Update</th>
			      <th style="font-size: 20px;" scope="col">Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach begin="0" end="${flight_count}" var="flight" items="${flights}" >
			   <c:if test="${flight.date_ eq null}">
			    <tr>
			      <td align="center" style="font-size: 20px;"><br>${flight.id}<br></td>
			      
			      <c:forEach begin="0" end="${plane_count}" var="plane" items="${planes}">
			      
			      		<c:if test="${plane.id eq flight.plane_id}">
			      			<td ><br>${plane.name} <br> <h6 style="color:green" > ${airline.name}</h6><br> </td>
			      		
			      
			      <td style="color:orange" ><br>&ensp;${flight.from_} <br>&ensp;${flight.dtime} Hrs<br></td>
			      <td style="color:green" ><br>&ensp;${flight.to_}<br>&ensp;${flight.atime} Hrs<br></td>
			      
			      <c:if test="${flight.day_ eq 1 }">
			      	<td align="center"><br>Sunday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 2 }">
			      	<td align="center"><br>Monday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 3 }">
			      	<td align="center"><br>Tuesday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 4 }">
			      	<td align="center"><br>Wednesday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 5 }">
			      	<td align="center"><br>Thursday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 6 }">
			      	<td align="center"><br>Friday<br></td>
			      </c:if>
			      <c:if test="${flight.day_ eq 7 }">
			      	<td align="center"><br>Saturday<br></td>
			      </c:if>
			      
			      <td align="center" style="font-size: 25px;"><br>${plane.capacity }<br></td>
			      <td align="center" style="font-size: 20px;"><br><i class="fa fa-inr"></i>${flight.fare}<br></td>
			      
			      <td align="center"><br><a href="${pageContext.request.contextPath}/UpdateFlightDetail/${flight.id}"><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
				  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
				</svg></a>
				
				
				
				</td>
			   
			      <td align="center"><br><a href="${pageContext.request.contextPath}/deleteFlight/${flight.id}"><svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="red" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
					</svg></a></td>
			    </c:if>
			      </c:forEach>
			    </tr>
			    </c:if>
			  </c:forEach>
			   </tbody>
			</table>
		</div>
	</div>

    
  </body>
  
	
	
		
			

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
	 <script type="text/javascript">
  var today = new Date();

  $(function(){
	    var dtToday = new Date();
	    
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    
	    var maxDate = year + '-' + month + '-' + day;
	    
	    $('#d1,#d2').attr('min', maxDate);
	});
  </script>
    
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	

    
    

  </body>
</html>


