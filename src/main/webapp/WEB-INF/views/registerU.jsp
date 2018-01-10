<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	
	 <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
	
	
    <!-- Bootstrap Core CSS -->
    <link href="resources/startbootstrap-simple-sidebar-1.0.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/startbootstrap-simple-sidebar-1.0.5/css/simple-sidebar.css" rel="stylesheet">
</head>
<body>


    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
              <li class="sidebar-brand">
                 
                       START
                    
                </li>
               
                <li>
                     <a href="registerUser.htm" >Register User</a><br>
                </li>
                <li>
                     <a href="loginPage.htm">Login</a><br>
                </li>
               
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

 <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    
                    
                    
<h2>Register a New User</h2>


<form:form action="registerUser.htm" commandName="user" method="post">
<div class="table table-striped">
<table>

 <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstname" pattern="^[a-zA-Z]*$" size="30" /> <font color="red"><form:errors path="firstname"/></font></td>
                </tr>
                
                
 <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastname" pattern="^[a-zA-Z]*$" size="30" /> <font color="red"><form:errors path="lastname"/></font></td>
                </tr>
                
                
 <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" pattern="^[a-zA-Z]*$" size="30" /> <font color="red"><form:errors path="username"/></font></td>
                </tr>
                
                                
 <tr>
                    <td>Password:</td>
                    <td><form:input path="password" pattern="^[a-zA-Z]*$" size="30" /> <font color="red"><form:errors path="password"/></font></td>
                </tr>
                
                                
 <tr>
                    <td> Address:</td>
                    <td><form:input path="address"  size="30" /> <font color="red"><form:errors path="address"/></font></td>
                </tr>
                
                                
 <tr>
                    <td>Email Id:</td>
                    <td><form:input path="email.emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" size="30" /> <font color="red"><form:errors path="email.emailId"/></font></td>
                </tr>
                

<tr>
<td>Admin:</td><td><input type="radio" id="usertype" name="usertype" value="admin" selected="admin" /></td>
</tr>
<tr>
<td>User:</td>
<td><input type="radio" id="usertype" name="usertype" value="NormalUser" selected="NormalUser"  checked/>
</tr>

<tr>
<td>
Select your most favorite movie genre.
</td>
<td>

<select id="selectedg" name="selectedg">
  <option id='option1' value="Horror"  selected='Horror'>Horror</option>
  <option id='option1' value="Comedy" selected='Comedy'>Comedy</option>
  <option id='option1' value="Romantic" selected='Romantic'>Romantic</option>
  <option id='option1' value="Action" selected='Action'>Action</option>
  <option id='option1' value="Drama" selected='Drama'>Drama</option>
  <option id='option1' value="Thriller" selected='Thriller'>Thriller</option>
  </select>
  
 
</td>
</tr>
    <table>
    

</div>

  <input class="btn btn-success" type="submit" value="Create User" /><br>
  

  

  
</form:form>

                    
                <c:if test="${action1!=null}">
                <c:if test="${action1=='success'}">
   <h4>User is successfully created</h4>
      </c:if>  
         <c:if test="${action1=='adminexists'}">
   <h4>Admin already exists</h4>
      </c:if> 
         <c:if test="${action1=='userexists'}">
   <h4>User already exists</h4>
      </c:if> 
   </c:if>       
                             
                              <a href="#menu-toggle" class="btn btn-default" id="menu-toggle" class='btn btn-primary pull-right'>Toggle Menu</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>


    <!-- jQuery -->
    <script src="resources/startbootstrap-simple-sidebar-1.0.5/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/startbootstrap-simple-sidebar-1.0.5/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
</body>
</html>