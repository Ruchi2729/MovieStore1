<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>



<title>Insert title here</title>


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
                         
                         <form action="addMovie.htm" method="post">
                         <h2>Add Movies To the store database</h2>

<div class="table table-striped">
                            <table border='1'>
       
                            
                              <tr>
                       
                            <td><IMG SRC="${movie.poster}">
                            </td>
                            <td>
                            <div class="table table-striped">
                            <table border='1' >
                         <tr>
                            <td>Title</td>
                            <td>${movie.title}
                            </td>
                            </tr>
                              <tr>
                            <td>Year</td>
                            <td>${movie.year}
                            </td>
                            </tr>
                              <tr>
                            <td>Director</td>
                            <td>${movie.director}
                            </td>
                            </tr>
                            <tr>
                            <td>Actor</td>
                            <td>${movie.actor}
                            </td>
                            </tr>
                            <tr>
                            <td>Writer</td>
                            <td>${movie.writer}
                            </td>
                            </tr>
                            <tr>
                            <td>Plot</td>
                            <td>${movie.plot}
                            </td>
                            </tr>
                            <tr>
                            <td>IMDB Rating</td>
                            <td>${movie.IMDBrating}
                            </td>
                            </tr>
                            
                            <tr>
                            <td>Genres</td>
                            <td>
                            <c:forEach var="genre" items="${movie.genres}">
                               ${genre.genreName},
                            </c:forEach>
                            
                            </td>
                            </tr>
                            </table>
                            </div>                    
                            </td>
                            </tr>
        </table>
                            </div>
                            

Decide the price <input type="number" id="price" name="price" required>
<input type="submit" name="submit" value="add movie" class="btn btn-success" >

</form>
             <c:if test="${action1!=null}">
   <h4>Movie is successfully addes to database</h4>
   </c:if>       
                               
                         
<a href="#menu-toggle" class="btn btn-default" id="menu-toggle" class='btn btn-primary pull-right'>Toggle Menu</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
                
           <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 
    <!-- jQuery -->
    <script src="resources/startbootstrap-simple-sidebar-1.0.5/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/startbootstrap-simple-sidebar-1.0.5/js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>   


</body>
</html>