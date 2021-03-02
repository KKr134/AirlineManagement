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
	
    <title>Book ticket</title>
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
               
		     
				
            </nav></div>
            
           <div class="Container" align="center">
	<div class="Container" align="center" style="width: 50%;">
		
		<br> <br><br> <br><br> <br>
		<a href="" data-toggle="modal" data-target="#modalLoginForm"><button class="btn btn-secondary btn-lg">Add Passenger</button> </a>
		
		<hr color=white>	 <br>
		<div class="jumbotron" align="center" style="width: 100%;">
		<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					  aria-hidden="true" >
					  <div class="modal-dialog" role="document" >
					    <div class="modal-content" style="background: #f2f2f2">
					      <div class="modal-header text-center">
					        <h4 class="modal-title w-100 font-weight-bold">Enter Passenger Detail</h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					       <form action="${pageContext.request.contextPath}/AddPassenger" method="post">
					      <div class="modal-body mx-3">
					       
					       
					          <label data-error="wrong" data-success="right" for="defaultForm-email" >Passenger Name</label>
					          <input type="text"  class="form-control validate" name="name" placeholder="Enter here" required>
					        
					        
					          
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Date Of Birth</label>
					          <input type="Date"  class="form-control validate" name="dob" required>
					        
					        	 
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Select Gender</label>
					          <select  class="form-control validate" name="gender"  required>
					          	
					      			  <option>Male</option>
								      <option>Female</option>	
								      <option>Other</option>
								     
					          	
					          </select>
							 
					          
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Select ID proof</label>
					          <select  class="form-control validate" name="idType"  required>
					          	
					      			  <option>Aadhar</option>
								      <option>PAN</option>	
								      <option>Passport</option>
								      <option>Voter ID</option>
								     
					          	
					          </select>
					        
					         <label data-error="wrong" data-success="right" for="defaultForm-pass">Enter ID no.</label>
					         <input type="text"  class="form-control validate" name="gid" placeholder="e.g. 123456789" required>
					        
					         <div class="modal-footer d-flex justify-content-center">
					        	<button type="submit" class="btn btn-secondary">Proceed</button>
					      	</div>
					
					      </div>
					     </form>
					    </div>
					  </div>
					</div>
					
					
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      
			      <th align="center" scope="col">PASS. NAME</th>
			      <th align="center"  scope="col">DOB</th>
			      <th align="center"  scope="col">SEX</th>
			      <th align="center"  scope="col">ID PROOF</th>
			      <th align="center"  scope="col">ID NUMBER</th>
			      <th align="center"  scope="col">DISCARD?</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach begin="0" end="${passenger_count}" var="passenger" items="${passengers}" >
			    <tr>
			      <td align="center" >${passenger.name}</td>
			      <td align="center" >${passenger.dob}</td>
			      <td align="center" >${passenger.gender}</td>
			      <td align="center" >${passenger.idType}</td>
			      <td align="center" >${passenger.gid}</td>
			     
			   
			      <td align="center" ><a href="${pageContext.request.contextPath}/deletePass/${passenger.id}"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
					</svg></a></td>
			    </tr>
			  </c:forEach>
			   </tbody>
			</table>
			
			<c:choose>
				  <c:when test="${passenger_count eq 0}">
				    <a  > <button class="btn btn-success btn-lg" disabled>Proceed</button> </a>
				  </c:when>
				  		
				  <c:otherwise>
				    <a href="${pageContext.request.contextPath}/BookAll" ><button class="btn btn-success btn-lg">Proceed</button> </a>
				  </c:otherwise>
			</c:choose>
			 
			
		</div>
		
		
		<hr color=white>
		
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

       
	
    
    
    
    
    
    

  </body>
</html>






