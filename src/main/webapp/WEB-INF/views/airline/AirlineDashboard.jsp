<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
	
    <title>AirlineDashBoard</title>
  </head>
  <body style="background-image: url('${pageContext.request.contextPath}/static/images/kk.jpg');">
  
   
  	<div class="wrapper">
         <header >
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
                     
                     <li><a href="${pageContext.request.contextPath}/EditAirlineProfile">Update Profile</a></li>
                     <li><a href="${pageContext.request.contextPath}/AirlineLogout">Logout</a></li>
                     <li><a >You are logged in as ${airline.name}</a></li>
                  </ul>
               </div>
               
		     
				
            </nav>
            <br> <br>
            <div class="container" align="center" style="width: 50%;" >
 
		  
		  <div class="container" align="center">
		  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
		  <h2 align="center"  style="color:white">Welcome ${airline.name }</h2> <br>
	 
	 	
	 		 	
  		<div class="container" align="center">
		
		<a href="${pageContext.request.contextPath}/AddPlane" ><button type="button" class="btnn warning btn-lg">Add New Plane</button></a>		
		<hr color=white >
		<hr color=white >
		<div class="row">
		<div class="col-md-6" >
		<div class="container" align="center">
		<a href="${pageContext.request.contextPath}/UpdatePlane"><button type="button" class="btnn info btn-lg">Update Plane Details</button></a>	 	
	 	<hr color=white>
	  	<a href="${pageContext.request.contextPath}/AddFlight"><button type="button" class="btnn info btn-lg">Add a Flight Schedule</button>	</a> 	
	  	
	 	</div>
	 	</div>
	 	<hr color=white>
	 	<div class="col-md-6" >
	 	<div class="container" align="center">
	 	<a href="${pageContext.request.contextPath}/RemovePlane" ><button style="width:230px" type="button" class="btnn success btn-lg">Remove Plane</button></a> 
	 	<hr color=white>
	 	<a href="${pageContext.request.contextPath}/UpdateFlight"><button type="button" class="btnn success btn-lg">Update Flight Schedule</button></a> 
	 	</div>
	 	</div>
	 	</div>
	 	<hr color=white><hr color=white >
	 	<div class="container" align="center">
	 	<a href="${pageContext.request.contextPath}/AirlineLogout"><button type="button" class="btnn danger btn-lg">Log Out</button></a>
		</div>
	 	<div class="container" align="center">
	 		</div></div> 
	 	<!-- <div class="modal fade" id="modalLoginForm3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					  aria-hidden="true" >
					  <div class="modal-dialog" role="document" >
					    <div class="modal-content" style="background: white">
					      <div class="modal-header text-center">
					        <h4 class="modal-title w-100 font-weight-bold">Check Ticket Status</h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					       <form action="checkStatus" method="post">
					      <div class="modal-body mx-3">
					       
					       <i class="fas fa-envelope prefix grey-text" ></i>
					          <label >Enter Ticket ID</label>
					          <input required type="number"  class="form-control validate" name="id" placeholder="e.g. 54321">
					        
					         <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" class="btnn info btn-lg">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div>
				
				<div class="modal fade" id="modalLoginForm1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					  aria-hidden="true" >
					  <div class="modal-dialog" role="document" >
					    <div class="modal-content" style="background: white">
					      <div class="modal-header text-center">
					        <h4 class="modal-title w-100 font-weight-bold">Book Tickets</h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					       <form action="BookTicket" method="post">
					      <div class="modal-body mx-3">
					       
					       <i class="fas fa-envelope prefix grey-text" ></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email" >Enter Source City</label>
					          <input required type="text"  class="form-control validate" name="source" placeholder="Select Source City">
					        
					        <hr color=white>
					          <i class="fas fa-envelope prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Enter Destination City</label>
					          <input required type="text"  class="form-control validate" name="dest" placeholder="Select Destination City">
					        
							 <hr color=white>
					          <i class="fas fa-lock prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Select Date</label>
					          <input required type="date" class="form-control validate" name="date" placeholder="e.g. 10-12-2020">
					        
					         <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" class="btnn info btn-lg">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div>
					
					
					<div class="modal fade" id="modalLoginForm2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					  aria-hidden="true" >
					  <div class="modal-dialog" role="document" >
					    <div class="modal-content" style="background: white">
					      <div class="modal-header text-center">
					        <h4 class="modal-title w-100 font-weight-bold">Check Seat Availability</h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					       <form action="CheckSeatAvailability" method="post">
					      <div class="modal-body mx-3">
					       
					       <i class="fas fa-envelope prefix grey-text" ></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email" >Enter Source City</label>
					          <input required type="text"  class="form-control validate" name="source" placeholder="Select Source City">
					        
					        <hr color=white>
					          <i class="fas fa-envelope prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Enter Destination City</label>
					          <input required type="text"  class="form-control validate" name="dest" placeholder="Select Destination City">
					        
							 <hr color=white>
					          <i class="fas fa-lock prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Select Date</label>
					          <input required type="date" class="form-control validate" name="date" placeholder="e.g. 10-12-2020">
					        
					         <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" class="btnn info btn-lg">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div> -->
	
			</div>
			</div>
           </div>
           </header>
         </div>
  
    
  </body>
  
  
</html>