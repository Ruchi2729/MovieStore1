<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.resizedTextbox {width: 100px; height: 20px}

<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
</style>
<script>


</script>


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
                     <a href="homePage.htm?action=homePage">Search Movies</a><br>
                </li>
                
                 <li>
                     <a href="loginOutPage.htm" >Logout</a><br>
                </li>
                
                <li>
                     <a href="suggestionPage.htm" >See Your Suggestions</a><br>
                </li>
               
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

 <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    <h1>${error}</h1> 
                    <table>
                             <tr><h1>${moviename}</h1> </tr>
                             <tr><td><IMG SRC="${poster}"></td>
                             <td>
                             <c:if test="${avgrating==5}">
                            <h3> &#x2605 &#x2605 &#x2605 &#x2605 &#x2605</h3><br>
                             </c:if>
                              <c:if test="${avgrating==4}">
                              <h3>&#x2605 &#x2605 &#x2605 &#x2605 &#x2606</h3><br>
                             </c:if>
                              <c:if test="${avgrating==3}">
                              <h3>&#x2605 &#x2605 &#x2605 &#x2606 &#x2606</h3><br>
                             </c:if>
                              <c:if test="${avgrating==2}">
                              <h3>&#x2605 &#x2605 &#x2606 &#x2606 &#x2606</h3><br>
                             </c:if>
                              <c:if test="${avgrating==1}">
                             <h3> &#x2605 &#x2606 &#x2606 &#x2606 &#x2606</h3>h3><br>
                             </c:if>
                   
                             <div class="dropdown">
  <button class="dropbtn">${noofuserswholike} users like this movie</button>
  <div class="dropdown-content">
  
  <c:forEach items="${users}" var="user" >
    <a href="#">"${user}"</a>
  
    </c:forEach>
  </div>
</div>
                             <h3>IMDB Rating:${imdbRating}</h3><br>
                             <h3>Store User Rating:${avgrating}</h3><br>
                             
                             <h3>Reviews</h3><br>
                             <table border='1'>
                             <tr>
                             <td>
                             User
                             </td>
                              <td>
                             Comments
                             </td>
                             </tr>
                             <c:forEach items="${moreview}" var="revie" >
                             <tr>
                             <td>
                             ${revie.reviewer.firstname}
                             </td>
                              <td>
                              ${revie.description}
                             </td>
                             </tr>
                             </c:forEach>
                             
                             </table>
                            
                             </td>
                             </tr>
                              <div class="container">
                              </table>
                              
                              

 
</div>

             
            
                        
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