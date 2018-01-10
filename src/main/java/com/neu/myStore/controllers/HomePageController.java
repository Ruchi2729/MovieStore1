package com.neu.myStore.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.MovieDAO;
import com.neu.myStore.dao.UserDAO;
import com.neu.myStore.pojo.Genre;
import com.neu.myStore.pojo.Movie;
import com.neu.myStore.pojo.Review;
import com.neu.myStore.pojo.User;

@org.springframework.stereotype.Controller
@RequestMapping("/homePage.htm")
public class HomePageController 
{
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDAO;
	


	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) throws  IOException, JSONException 
	{ 
		HttpSession session = request.getSession();
		
		if(request.getParameter("action")!=null)
		{
			if(request.getParameter("action").equalsIgnoreCase("searchmovie"))
			{
				String searchString=request.getParameter("searchkey").trim().replace(" ","");

				//String password=request.getParameter("password");
				searchString.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
				
				if (searchString.equals("") && searchString.equals("")) {
					 request.setAttribute("action", "invalidinput");

						if(((User) session.getAttribute("user")).getAcountType().equals(User.AccountType.Admin))
						{
					        return "adminHomePage";
					    }
						else
						{
							
							return "userHomePage";
						}
		         }
				URL apiurl = new URL("http://www.omdbapi.com/?t="+searchString+"&y=&plot=short&r=json");
		        URLConnection yc = apiurl.openConnection();
		        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		        String inputLine;
		        StringBuilder sb = new StringBuilder();
		        while ((inputLine = in.readLine()) != null) 
		        {
		            System.out.println(inputLine);
		            sb.append(inputLine);
		        }
		        JSONObject json = new JSONObject(sb.toString());
		        
		      if(json.get("Response").toString().equalsIgnoreCase("false"))
		      {
		    	request.setAttribute("task", "error");  
		      }
		      else
		      {
		    	  request.setAttribute("task", "found"); 
		      Movie movie=new Movie();
		      movie.setTitle((String)json.get("Title"));
		      movie.setActor((String)json.get("Actors"));
		      movie.setDirector((String)json.get("Director"));
		      movie.setImdbid((String) json.get("imdbID"));
		      //((Movie) movie).setImdbid((String) json.get("imdbID"));
		      
		      Set<Genre>genres=new HashSet<Genre>();
		      String[] genres1=json.get("Genre").toString().split(",");
		      for (String s: genres1) {           
		          s.trim();
		          Genre genre=new Genre();
		          genre.setGenreName(s);
		          genres.add(genre);
		        
		      }
		      
		      movie.setGenres(genres);
		      movie.setIMDBrating((String)json.get("imdbRating"));
		      movie.setPlot((String)json.get("Plot"));
		      movie.setPoster((String)json.get("Poster"));
		      movie.setWriter((String)json.get("Writer"));
		      movie.setYear((String)json.get("Year"));
		      
		      
		      
		    
		      
		     if( movieDAO.get(movie.getImdbid())==null)
		     {
		    	request.setAttribute("uiaction", "notfound"); 
		    	 
		     }
		     else if(movieDAO.get(movie.getImdbid()).isAvailability()==false)
		     {
		    	 request.setAttribute("uiaction", "notfound"); 
		    	 movie.setMovieid(movieDAO.get(movie.getImdbid()).getMovieid());
		    	//movie=movieDAO.get(movie.getImdbid());
		    	 movie.setAvailability(false);
		    	 movie.setPrice(movieDAO.get(movie.getImdbid()).getPrice());
		     }
		     else 
		     {
		    	 request.setAttribute("uiaction", "found");  
		    	movie.setMovieid(movieDAO.get(movie.getImdbid()).getMovieid());
		    	//movie=movieDAO.get(movie.getImdbid());
		    	 movie.setAvailability(true);
		    	movie.setPrice(movieDAO.get(movie.getImdbid()).getPrice());
		     }
		      
		      
		     User us = (User)request.getSession().getAttribute("user");
		     String choiceAttr="Like";
		     String classAttr="btn btn-success";
		     for(Movie mv:us.getMovieslikedbyusers())
		     {
		    	if(mv.getImdbid().equalsIgnoreCase(movie.getImdbid())) 
		    	{
		    		choiceAttr="Unlike";
		    		classAttr="btn btn-primary";
		    	}
		    	
		     }
		     
		     for(Review review:us.getMyreviews())
		    	{
		    		Movie reviewedMovie=review.getMovie();
		    		if(reviewedMovie.getImdbid().equalsIgnoreCase(movie.getImdbid())) 
			    	{
		    			request.setAttribute("ureviews", review.getDescription());
			    	}
		    	}
		     
		     request.getSession().setAttribute("movie", movie);
		     request.setAttribute("choiceAttr", choiceAttr);
		     request.setAttribute("classAttr", choiceAttr);
		        
		      }
		       
		       
			}
			
		}
		else
		{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		username.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		password.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();  
		 if (username.equals("") && password.equals("")) {
			 request.setAttribute("action", "invalidinput");
				return "login";
         }
		   
			User user=userDao.get(username,password);
			if(user!=null)
			{
			request.getSession().setAttribute("movie", null);
			session.setAttribute("user", user);
			}
			else
			{
				request.setAttribute("actionName", "register");
				return "registerRequest";
			}
		}
		
		
		if(((User) session.getAttribute("user")).getAcountType().equals(User.AccountType.Admin))
		{
	        return "adminHomePage";
	    }
		else
		{
			
			return "userHomePage";
		}
	}
	

}
