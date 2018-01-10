<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>

</style>

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
                     <a href="homePage.htm?action=homepage">Search Movies</a><br>
                </li>
                
                 <li>
                     <a href="loginOutPage.htm" >Logout</a><br>
                </li>
                
                <li>
                     <a href="showRequestedMovies.htm" >Requested Movies</a><br>
                </li>
               
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

 <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                            <h1>Following Movies are suggested by the user</h1>
                              <div class="container">
                              <table border=1>
                              <tr>
                              <td>
                              IMDB ID
                              </td>
                               <td>
                              Title
                              </td>
                              </tr>
                              <c:forEach items="${reqmovieList}" var="reqmovie1" >
                              <tr>
                              <td>
                              ${reqmovie1.imdbid}
                              </td>
                              <td>
                                 ${reqmovie1.title}
                              </td>
                              </tr>
                              </c:forEach>
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