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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    <title>Airline Login</title>
  </head>
  <body>
  
   
  	<div class="wrapper">
         <header style="background-image: url('${pageContext.request.contextPath}/static/images/pp.jpg');">
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
                     <li><a href="${pageContext.request.contextPath}/UserLogin">User Login</a></li>
                     <li><a href="${pageContext.request.contextPath}/AirlineRegistration">New airline Sign up</a></li>
                     
                     <li><a href="${pageContext.request.contextPath}/AdminLogin">Admin</a></li>
                     <li><a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
                  </ul>
               </div>
               
		     
				
            </nav>
            <br> <br>
            <div class="container" align="center" style="width: 40%;" >
 
  
  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
  <h2 align="center"  style="color:white">Airline Login</h2> <hr>
  <h5 align="center" style="color:white">${message}</h5> <hr>
	 <form  action="${pageContext.request.contextPath}/AirlineDashboard"  method="post" style="color:white">
	 
	  <div class="form-group">
	    <h4>Email address</h4>
	    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="abc@xyz.com" required>
	    
	  </div>
	  
	   <div class="form-group">
	    <h4>Password</h4>
	    <input type="password" class="form-control" name="password" placeholder="Enter Here" required>
	   
	  </div>
	  
	  <div class="form-group form-check" >
	    
	    <small>New user? <a href="${pageContext.request.contextPath}/AirlineRegistration" style="color:white"> Sign up here</a></small>
	  </div>
	  <div class="container" align="center">
	  <button  type="submit" class="btn btn-success btn-lg">LOG IN</button></div><hr>
	</form>
	</div>
	</div>
           
         </header>
         
      </div>
  
    
  </body>
  
  
</html>