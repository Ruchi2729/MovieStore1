<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.resizedTextbox {width: 100px; height: 20px}
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
                     <a href="homePage.htm?action=homepage">Search Movies</a><br>
                </li>
                
                 <li>
                     <a href="loginOutPage.htm" >Logout</a><br>
                </li>
                
               
               
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

 <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                   
                              <div class="container">
                             
                               <c:forEach items="${movieList}" var="movie1" >
                              <table>
                              
                              <tr>
                              <td>
                              <IMG SRC="${movie1.poster}">
                              </td>
                              <td>
                            <table>
                              
                              <tr>
                            <td>Title</td>
                            <td>${movie1.title}
                            </td>
                            </tr>
                              <tr>
                            <td>Year</td>
                            <td>${movie1.year}
                            </td>
                            </tr>
                              <tr>
                            <td>Director</td>
                            <td>${movie1.director}
                            </td>
                            </tr>
                            <tr>
                            <td>Actor</td>
                            <td>${movie1.actor}
                            </td>
                            </tr>
                            <tr>
                            <td>Writer</td>
                            <td>${movie1.writer}
                            </td>
                            </tr>
                            <tr>
                            <td>Plot</td>
                            <td>${movie1.plot}
                            </td>
                            </tr>
                            <tr>
                            <td>IMDB Rating</td>
                            <td>${movie1.IMDBrating}
                            </td>
                            </tr>
                            
                            <tr>
                            <td>Genres</td>
                            <td>
                            <c:forEach var="genre" items="${movie1.genres}">
                               ${genre.genreName},
                          </c:forEach>
                            
                            </td>
                              
                            </tr>
                            
                            </table>
                        
                             <form action="movieDetailPage2.htm" method="get"><
                            <input type="submit" value="Go To This Movie">
                            <input type="hidden" name="moimdb" value="${movie1.imdbid}">
                            </form>
                            </td>
                            </tr>
                          
                             </table>
                               </c:forEach>                      

 
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