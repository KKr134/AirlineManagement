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
  <body>
  
   
  	<div class="wrapper">
         <header style="background-image: url('${pageContext.request.contextPath}/static/images/a5.jpg');">
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
                     
                     <li><a href="${pageContext.request.contextPath}/EditAirlineProfile">Update Info</a></li>
                     <li><a href="${pageContext.request.contextPath}/AirlineLogout">Logout</a></li>
                     <li><a >You are logged in as ${airline.name}</a></li>
                  </ul>
               </div>
               
		     
				
            </nav>
            <br> <br>
             <div class="container" >
 
  <div class="container" align="center" style="width: 50%;" >
 
  
  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
  <h2 align="center"  style="color:white">Update Profile</h2> <hr color=white>
  <p align="center" style="color:white; font-size: 12px;" >${message}</p> <br>
  
  <form action="${pageContext.request.contextPath}/UpdateAirline" method="post" style="color:white">
	 
	  <div class="form-group">
	    <label for="name">Airline Name</label>
	    <input type="text" class="form-control" name="name" value="${airline.name}" required>
	  </div>
	  
	  <div class="row">
	   <div class="col">
	   		<div class="form-group">
	    <label for="email">Official Email address</label>
	    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" value="${airline.email}" readonly required>
	    <small id="emailHelp" class="form-text text-muted">You cannot change your email.</small>
	  </div>
	   </div>
	  
	 
	  <div class="col">
	  <div class="form-group">
	    <label for="contact">Phone number</label>
	    <input type="text" class="form-control" name="contact" maxlength="12" value="${airline.contact}" required>
	  </div>
	  </div>
	  
	  
	  
	   </div>
	   
	   <div class="form-group">
	    <label for="manager">Manager's Name</label>
	    <input type="text" class="form-control" name="manager" value="${airline.manager}" required>
	  </div>
	  
	   <div class="row">
	   <div class="col">
	   	<div class="form-group">
	    <label for="password">New Password</label>
	    <input type="password" class="form-control" name="password" value="${airline.password}" required>
	  
	  </div>
	   </div> 
	   
	    <br>
	   
	   <div class="col">
	   
	   <div class="form-group">
	    <label for="ConfirmPassword">Confirm Password</label>
	    <input type="text" class="form-control" name="ConfirmPassword" required>
	  </div>
	  </div>
	  
	   
	  
	   </div>
	   
	  
	  
	  
	 
	  <div class="container" align="center">
	  <button type="submit" class="btn btn-success btn-lg">Update</button>
	  <hr color=white>
	  </div>
	  </form>
	</div>
	</div>
	</div>
           </header>
         </div>
  
    
  </body>
  
  
</html>










