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
	
    <title>User Registration</title>
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
                     
                     <li><a href="${pageContext.request.contextPath}/UserDashboard">Dashboard</a></li>
                     <li><a href="#">Get Support</a></li>
                     <li><a href="${pageContext.request.contextPath}/UserLogout">Logout</a></li>
                     <li><a >You are logged in as ${user.name}</a></li>
                  </ul>
               </div>
               
		     
				
            </nav>
            <br> <br>
            <div class="container" align="center" style="width: 40%;" >
 
  
  <div class="jumbotron" align="left" style="width: 100%; background-color: transparent; ">
  <h2 align="center"  style="color:white">Edit Profile</h2> <hr color=white>
  <p align="center" style="color:white; font-size: 12px;" >${message}</p> <br>
  
  <form action="${pageContext.request.contextPath}/UpdateUser" method="post" style="color:white">
	 <div class="row">
		<div class="col-md-5">
	  <div class="form-group">
	    <label for="name">User Name</label>
	    <input type="text" class="form-control" name="name" required value="${user.name}" placeholder="Enter Here">
	  </div>
	  </div>
	  <div class="col-md-7">
	  <div class="form-group">
	    <label for="email">Email address</label>
	    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" value="${user.email}" required placeholder="e.g. abcde@xyz.com" readonly>
	    
	  </div>
	  </div>
	  </div>
	  <div class="form-group">
	    <label for="contact">Phone Number</label>
	    <input type="text" class="form-control" name="mobile" maxlength="12" value="${user.mobile}" required placeholder="e.g. 9998887776">
	  </div>
	  
	   <div class="form-group">
	    <label for="address">Home Address</label>
	    <input type="text" class="form-control" name="address" value="${user.address}" required placeholder="Enter Here">
	  </div>
	  <div class="row">
	  <div class="col-md-6">
	   <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" name="password" required placeholder="Enter Here">
	    	  </div>
	  </div>
	  <div class="col-md-6">
	   <div class="form-group">
	    <label for="ConfirmPassword">Confirm Password</label>
	    <input type="text" class="form-control" name="ConfirmPassword" required placeholder="Enter again">
	  </div>
	  </div>
	  </div>
	  
	  
	   <div class="container" align="center">
	  <button type="submit" class="btn btn-success btn-lg">Proceed</button>
	  <hr color=white>
	  </div>
	</form>
	
	</div>
	</div>
   
    </header>
          </div>
     
    
   
           
         
  
    
  </body>
  
  
</html>





