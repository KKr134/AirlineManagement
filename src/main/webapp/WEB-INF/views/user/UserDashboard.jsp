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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	
    <title>User Dashboard</title>
  </head>
  <body style="background-image: url('${pageContext.request.contextPath}/static/images/kk.jpg');">
  
   
  	<div class="wrapper" style="background-image: url('${pageContext.request.contextPath}/static/images/kk.jpg')">
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
                     
                     <li><a href="${pageContext.request.contextPath}/EditUserProfile">Edit Profile</a></li>
                     <li><a href="${pageContext.request.contextPath}/#">Get Support</a></li>
                     <li><a href="${pageContext.request.contextPath}/UserLogout">Logout</a></li>
                     <li><a >You are logged in as ${user.name}</a></li>
                  </ul>
               </div>
               
		     
				
            </nav>
            <br> <br>
            <div class="container" align="center" style="width: 40%;" >
 
  
  <div class="container" align="center">
  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
  <h2 align="center"  style="color:white">Welcome ${user.name }</h2> <br>
  		
  		
  		<div class="container" align="center">
		
		<a href="" data-toggle="modal" data-target="#modalLoginForm1"><button type="button" style="width: 185px; font-size:22px; height: 70px" class="btnn info btn-lg">Book Ticket</button></a> 
		<hr color=white >
		<hr color=white >
		<div class="row">
		<div class="col-md-6" >
		<div class="container" align="center">
		<a href="" data-toggle="modal" data-target="#modalLoginForm3"><button style="width: 170px; font-size:19px; height: 85px"  type="button" class="btnn success btn-lg">Check Status</button></a> 
	 	<hr color=white>
	 	<a href="${pageContext.request.contextPath}/BookedTickets"><button type="button" style="width: 170px; font-size:19px; height: 85px" class="btnn danger btn-lg">Recent Bookings</button></a>   
	 	
	  	
	 	</div>
	 	</div>
	 	<hr color=white>
	 	<div class="col-md-6" >
	 	<div class="container" align="center">
	 	<a href="" data-toggle="modal"  data-target="#modalLoginForm2"><button type="button" style="width: 170px; font-size:19px; height: 85px" class="btnn success btn-lg">Check Availability</button></a> 
	 	<hr color=white>
	 	<a href="${pageContext.request.contextPath}/cancelledTickets" > <button type="button" style="width: 170px; font-size:19px; height: 85px" class="btnn danger btn-lg">Cancelled Tickets</button></a>
	 	
	 	</div>
	 	</div>
	 	</div>
	 	<hr color=white><hr color=white >
	 	<div class="container" align="center">
	 	<a href="${pageContext.request.contextPath}/UserLogout" ><button type="button" style="width: 185px; font-size:19; height: 70px" class="btnn warning btn-lg"><h4 >Log Out</h4></button></a> 
	 
	 	</div>
	 	<div class="container" align="center">
	 		</div></div> 
	 	<div class="modal fade" id="modalLoginForm3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
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
					          <label data-error="wrong" data-success="right" for="defaultForm-email" >Select Source City</label>
					          <select  class="form-control" name="source"  required >
								     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
										    <option>${airport.city},${airport.countryCode}</option>
										</c:forEach>     
						  </select>	
					        <hr color=white>
					          <i class="fas fa-envelope prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Select Destination City</label>
					          <select  class="form-control" name="dest"  required >
								     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
										    <option>${airport.city},${airport.countryCode}</option>
										</c:forEach>     
						  </select>	
							 <hr color=white>
					          <i class="fas fa-lock prefix grey-text"></i>
					          <label data-error="wrong" data-success="right"  for="defaultForm-pass">Select Date</label>
					          <input required type="date" class="form-control validate"  id='d2'name="date" placeholder="e.g. 10-12-2020">
					        
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
					          <label data-error="wrong" data-success="right" for="defaultForm-email" >Select Source City</label>
							<select  class="form-control" name="source"  required >
								     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
										    <option>${airport.city},${airport.countryCode}</option>
										</c:forEach>     
						  </select>					        
					        <hr color=white>
					          <i class="fas fa-envelope prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Select Destination City</label>
					          <select  class="form-control" name="dest"  required >
								     	<c:forEach begin="0" end="${airport_count}" var="airport" items="${airports}" >
										    <option>${airport.city},${airport.countryCode}</option>
										</c:forEach>     
						   </select>	
							 <hr color=white>
					          <i class="fas fa-lock prefix grey-text"></i>
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Select Date</label>
					          <input required type="date" class="form-control validate" id='d1' name="date" placeholder="e.g. 10-12-2020">
					        
					         <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" class="btnn info btn-lg">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div>
					
	
	 </div>
	 	
    </div>
   </div>
    </header>
          </div>
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

