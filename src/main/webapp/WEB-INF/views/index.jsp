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
  <body >
    
 
      <div class="wrapper">
         <header style="background-image: url('${pageContext.request.contextPath}/static/images/airplane.jpg');">
            <nav>
               <div class="menu-icon">
                  <i class="fa fa-bars fa-2x"></i>
               </div>
               <div class="logo">
                  A<small style="font-size: 13px">irline </small>M<small style="font-size: 13px">anagement </small>S<small style="font-size: 13px">ystem</small>
               </div>
               <div class="menu">
                  <ul>
                     <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                     <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                     
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
               
		     
				
            </nav>
            <br>
           
           
            <div class="container" style="align: center;">
            <br>
            <br>
            <br>
          
			<br>
            <br>
               <div class="section-center">
			<div class="container">
					
						
				<div class="row">
				<div class="col-md-4">
						
					</div>
					<div class="col-md-2">
						<div class="booking-cta">
													</div>
					</div>
					<div class="col-md-5 col-md-offset-1" >
					 <div  align="center">
								
			<h3 style="color:white">BOOK YOUR FLIGHT TODAY</h3>
									<p style="font-size:13px;color:white">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
			</div>	
						<div class="booking-form" style="background-color:#f8f8f8">
							<form action="CheckSeatAvailability" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label"  style="color:#00e5ff">Flying from</span>
											 <select  class="form-control" name="source"  required >
										     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
												    <option>${airport.city},${airport.countryCode}</option>
												</c:forEach>     
											</select>
											
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<span  class="form-label" style="color:#00e5ff">Flying to</span>
											<select  class="form-control" name="dest"  required >
										     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
												    <option>${airport.city},${airport.countryCode}</option>
												</c:forEach>     
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12" >
										<div class="form-group">
											<span class="form-label"  style="color:#00e5ff">Departing ON</span>
											<input class="form-control" id="txtDate" type="date" name="date" required>
										</div>
									</div>
									
								</div>
								
								<div class="form-btn">
									<button class="submit-btn"><b>Show flights</b></button>
								</div>
							</form>
						</div>
						<div class="container" style="align:center">
						<br>
						<b><p style=" color: white; font-size:13px ">&ensp;&ensp;&ensp;&ensp;New user ? <a href="${pageContext.request.contextPath}/UserRegistration" style="color: white"> Sign up here</a>  &ensp;&ensp; 
						&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;New airline ? <a href="${pageContext.request.contextPath}/AirlineRegistration" style="color: white"> Sign up here</a></p>
          			</b></div>
					</div>
				</div>
				</div>
				</div>
				</div>
         </header>
         
      </div>
 

   
	
    
	
    
    
    
    
    
    

  </body>
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
	    
	    $('#txtDate').attr('min', maxDate);
	});
  </script>
</html>