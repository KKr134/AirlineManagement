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
                     
				  <li><a href="${pageContext.request.contextPath}/UpdateAirport">View Airports</a></li>
				    <li><a href="${pageContext.request.contextPath}/AdminDashboard">Your Dashboard</a></li>
				    <li><a href="${pageContext.request.contextPath}/AdminLogout">Log Out</a></li>
				  
                     
                     <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                  </ul>
               </div>
               
		     
				
            </nav></div>
            
		<br> <br><br>
		<div class="container" align="center" style="width: 55%;" >
 
  
  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
  <h2 align="center"  style="color:white">Update Airport</h2> <hr>
  <h5 align="center" style="color:white">${message}</h5> <hr>
	 <form  action="${pageContext.request.contextPath}/updateairport/${airport_.id}"  method="post" style="color:white">
	 <div class="row">
		<div class="col-md-6">
	  <div class="form-group">
	    <label for="city">City</label>
	    <input type="text" class="form-control" name="city" required   value="${airport_.city}" placeholder="Enter Here">
	  </div>
	  </div>
	  <div class="col-md-6">
	  <div class="form-group">
	    <label for="Country">Country</label>
	    <select  class="form-control" name="country"  required value="${airport_.country}">
	     	<c:forEach begin="0" end="${country_count}" var="country" items="${countries}" >
			    <option>${country}</option>
			</c:forEach>     
	     </select>
	  </div>
	  </div>
	  </div>
	  <div class="form-group">
	    <label for="airportName">Airport Name</label>
	    <input type="text" class="form-control" name="airportName" required value="${airport_.airportName}" placeholder="Enter Here">
	  </div>
	  
	   <div class="form-group">
	    <label for="airportCode">Airport Code</label>
	    <input type="text" class="form-control" name="airportCode"  required value="${airport_.airportCode}" placeholder="Must be unique">
	  </div>
	 
	  
	  <div class="row">
	  <div class="col-md-6">
	  <small id="pwdtype" style="font-size: 12px"> <i> Choose a unique Airport Code</i></small>
	  
	  </div>
	  </div>
	   <div class="container" align="center">
	  <button type="submit" class="btnn success btn-lg">Proceed</button>
	  <hr color=white>
	  </div>
	</form>
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

