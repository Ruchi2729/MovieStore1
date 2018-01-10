<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.resizedTextbox {width: 100px; height: 20px}
</style>
<script>
function GetXmlHttpObject()
{
var xmlHttp=null;
try
  {
  // Firefox, Opera 8.0+, Safari
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  {
  // Internet Explorer
  try
    {
    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }
  catch (e)
    {
    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
return xmlHttp;
} 
var xmlHttp;
xmlHttp = GetXmlHttpObject();

function likeUnlikeMovies() {
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }

    //var query = "action=delete&user=" + userID;

    xmlHttp.onreadystatechange = function stateChanged()
    {
        if (xmlHttp.readyState == 4)
        {
            //var row = document.getElementById(rowID);
            //row.parentNode.removeChild(row);
            var json=JSON.parse(xmlHttp.responseText);
            if(json.isliked=="Like")
            	{
            	var butn=document.getElementById("lkbtn");
            	butn.setAttribute("value","Like")
            	butn.setAttribute("class","btn btn-success")
            	}
            else
            	{
            	var butn=document.getElementById("lkbtn");
            	butn.setAttribute("value","Unlike")
            	butn.setAttribute("class","btn btn-primary")
            	}
        }
    };
    xmlHttp.open("GET", "linkeunlikemovie.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send();
    return false;

}

function addReview()
{
	
	 if (xmlHttp == null)
	    {
	        alert("Your browser does not support AJAX!");
	        return;
	    }

	    //var query = "action=delete&user=" + userID;
	         var query = "myreview="+document.getElementById("myreview").value+"&selectoption=" +document.getElementById("selectoption").value;

	    xmlHttp.onreadystatechange = function stateChanged()
	    {
	        if (xmlHttp.readyState == 4)
	        {
	            //var row = document.getElementById(rowID);
	            //row.parentNode.removeChild(row);
	            var json=JSON.parse(xmlHttp.responseText);
	           
	            	var textbx=document.getElementById("myreview");
	            	textbx.readOnly = true;
	            	var successmsg=document.getElementById("successMessage");
	            	
	            	successmsg.innerHTML="successfully submitted review";
	          
	        }
	    };
	    xmlHttp.open("POST", "addReview.htm", true);

	    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    //alert(query);
	    xmlHttp.send(query);
	    return false;
	
	
	}
function requestMovie()
{

	 if (xmlHttp == null)
	    {
	        alert("Your browser does not support AJAX!");
	        return;
	    }

	    //var query = "action=delete&user=" + userID;

	    xmlHttp.onreadystatechange = function stateChanged()
	    {
	        if (xmlHttp.readyState == 4)
	        {
	            //var row = document.getElementById(rowID);
	            //row.parentNode.removeChild(row);
	            var json=JSON.parse(xmlHttp.responseText);
	           /* 
	            	var textbx=document.getElementById("myreview");
	            	textbx.readOnly = true; */
	            	var successmsg=document.getElementById("successMessage1");
	            	
	            	successmsg.innerHTML="successfully Requested Movie";
	          
	        }
	    };
	    xmlHttp.open("GET", "requestMovie.htm", true);
	    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xmlHttp.send();
	    return false;
	
	}

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
                
                 <li>
                     <a href="movieDetailPage.htm" >Go To This Movie</a><br>
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
                             <h1>Welcome Your Movie Library</h1> 
                              <div class="container">
                             <form action="homePage.htm" method="get">
                             Enter Movie name to search:<input type="text" pattern="^[a-zA-Z]*$" name="searchkey" required>
                             <input class="btn btn-success" type="submit" name="submit" value="search movie">
                             <input type="hidden" name="action" value="searchmovie">
                            </form>  
                           <c:if test="${not empty task}">
                            <c:if test="${task=='error'}">
                           <br> Movie Not Found!!!
                            </c:if>
                             <c:if test="${task=='found'}">
                           <br> Movie  Found!!!
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
                            
                     <c:if test="${not empty uiaction}">
                             <c:if test="${uiaction=='notfound'}">
                       <h2>This movie is not in store database</h2>
                      <input type="button" class="btn btn-success" name="requestToAdd" onclick=requestMovie() value="Request Movie">
                          <div id="successMessage1"></div>
                          </c:if>
                           <c:if test="${uiaction=='found'}">
                         <h3>This movie is in store database</h3><br>
                         <input type="button" id="lkbtn" class="${classAttr}" onclick=likeUnlikeMovies() value="${choiceAttr}"><br><br>
                     <input type="text"  id="myreview" value="${ureviews}" name="myreview" >

                     
<select id="selectoption" name="selectoption">
  <option id='option1' value="1"  selected='1'>*</option>
  <option id='option1' value="2" selected='2'>**</option>
  <option id='option1' value="3" selected='3'>***</option>
  <option id='option1' value="4" selected='4'>****</option>
  <option id='option1' value="5" selected='5'>*****</option>
</select>
<input type="button" class="btn btn-success" onclick=addReview() value="Submit Review"><br>
                     <div id="successMessage"></div>
                          </c:if>
                         </c:if>
                        
                         
                            </td>
                            </tr>
        </table>
                            </div>
                        
                            </c:if>

</c:if>
 
</div>

   <c:if test="${action=='invalidinput'}">
                         <h3>Wrong search string</h3>
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