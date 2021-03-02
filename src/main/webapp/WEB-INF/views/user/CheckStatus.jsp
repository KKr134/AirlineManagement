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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/kk.css">
	
	
	
    <title>Check Status</title>
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
				    <li><a href="${pageContext.request.contextPath}/AirlineDashboard">Your Dashboard</a></li>
				    <li><a href="${pageContext.request.contextPath}/AirlineLogout">Log Out</a></li>
				  </c:otherwise>
				</c:choose>
                     
                     <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                  </ul>
               </div>
               
		     
				
            </nav></div>
            
		<br> 
			<c:choose>
				  <c:when test="${ticket eq null}">
				   <br> <br> <br> <br> 
				   <div class="container" align="center">
				  	<div class="jumbotron" align="center">
				  		<h1 align="center" style="color:black">No Data Available !</h1>
				  	 </div> </div>
				  </c:when>
				  		
				<c:otherwise>
		<section class="container">
		<c:choose>
			<c:when test="${ticket.status eq waitlist }">
			<div class="container" align="center">
				  	<div class="jumbotron" align="center" style="height: 200px">
				  		<h1>Your ticket is Waitlisted</h1><h4> (Your WaitRank: ${waitrank}) </h4>
				  	 </div></div>
				
			</c:when>
			<c:otherwise>
			<div class="container" align="center">
				  	<div class="jumbotron" align="center" style="height: 200px">
			<h1>Booking Status: ${ticket.status } </h1>				  	
			 </div></div>
				
			</c:otherwise>
		</c:choose>
			
			  <div class="row">
			  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			    <c:forEach begin="0" end="${flight_count}" var="flight" items="${flights}">
				<c:if test="${flight.id eq ticket.fid}">
			    <article class="card fl-left" >
			      <section class="date" >
			        <time datetime="23th feb">
			        
			          <img alt="Status" src="${pageContext.request.contextPath}/static/images/${ticket.status}.jpg" style="width:117px ; height:120px ">
			        </time>
			      </section>
			      <section class="card-cont">
			        <small>passenger	</small>
			        <h3>${ticket.pname} &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Ticket ID- ${ticket.id}</h3>
			        
			        <div class="even-date">
			         <i class="fa fa-calendar"></i>
			         <time>
			         	<span>Age - ${ticket.age}</span>
			         <c:forEach begin="0" end="${plane_count}" var="plane" items="${planes}">
						<c:if test="${flight.plane_id eq plane.id}">
			           <span><b style="color: #960F2F; font-size:1.2em ">${plane.name}</b></span>
			           </c:if>
			           </c:forEach>
			           <span>${flight.date_}</span>
			         </time>
			        </div>
			        <div class="even-info">
			          <i class="fa fa-map-marker"></i>
			          <p style="font-size:1.5em  ;color:#9307FF"> ${flight.from_} ${flight.dtime}</p> 
					  <p style="font-size:1.5em ; color:#074BAF"> ${flight.to_}  ${flight.atime}</p>
			          
			        </div>
			        <%-- <a href="${pageContext.request.contextPath}/deleteTicket/${ticket.id}" >remove</a> --%>
			      </section>
			    </article>
			    </c:if>
			    </c:forEach>
			    
			    
			  
			</div> 
			  
	</section>
	</c:otherwise>
</c:choose> 
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
					        	<button type="submit" class="btn btn-secondary btn-lg">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div>
    <!-- Optional JavaScript; choose one of the two! -->

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



































