package com.neu.myStore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.MovieDAO;
import com.neu.myStore.dao.UserDAO;
import com.neu.myStore.pojo.Movie;
import com.neu.myStore.pojo.RequestedMovie;
import com.neu.myStore.pojo.Review;
import com.neu.myStore.pojo.User;

@Controller
public class UserOperationsController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDAO;
	
	
	@RequestMapping(value="/linkeunlikemovie.htm",method=RequestMethod.GET)
    public void initializeForm(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException 
	{ 
		User user=(User)request.getSession().getAttribute("user");
		Movie movie=(Movie)request.getSession().getAttribute("movie");
		boolean moviealreadiliked=false;
		String movielike;
		for(Movie mv:user.getMovieslikedbyusers())
		{
			if(mv.getImdbid().trim().equalsIgnoreCase(movie.getImdbid()))
			{
				moviealreadiliked=true;
			
			}
		}
		if(moviealreadiliked==true)
		{
			movielike="Like";
			
			user.getMovieslikedbyusers().remove(movie);
			movie.getUserswholike().remove(user);
			userDao.update(user,movie);
		}
		else
		{
		user.getMovieslikedbyusers().add(movie);
		movie.getUserswholike().add(user);
		userDao.update(user,movie);
		//movieDAO.update(movie);
		//userDao.delete(user);
		//userDao.create(username, password, emailId, firstName, lastName, address, accountype)(user);
		movielike="Unlike";
		}
		
		JSONObject obj = new JSONObject();

	
		obj.put("isliked",movielike);

		PrintWriter out = response.getWriter();
		        out.println(obj);
		//user.getMovieslikedbyusers().

    } 
	
	
	
	@RequestMapping(value="/addReview.htm",method=RequestMethod.POST)
    public void addReview(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException 
	{
		
		User user=(User)request.getSession().getAttribute("user");
		Movie movie=(Movie)request.getSession().getAttribute("movie");
		Review review=new Review();
		review.setDescription(request.getParameter("myreview"));
		review.setMovie(movie);
		review.setReviewer(user);
		review.setRating(Integer.parseInt(request.getParameter("selectoption")));
		user.getMyreviews().add(review);
		movie.getReviews().add(review);
		
		
		//Rating rating=new Rating();
//		rating.setRatedmovie(movie);
//	rating.setRatingno(Integer.parseInt(request.getParameter("select")));
//	movie.getRating().add(rating);
		
		
		userDao.updateReview(user,movie);
		
		
		JSONObject obj = new JSONObject();		
		obj.put("moviereview",review.getDescription());

		PrintWriter out = response.getWriter();
		        out.println(obj);
			
		
	}
	

	@RequestMapping(value="/requestMovie.htm",method=RequestMethod.GET)
    public void requestMovie(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException 
	{
		
		User user=(User)request.getSession().getAttribute("user");
		Movie movie=(Movie)request.getSession().getAttribute("movie");
		
		
	RequestedMovie reqmovie=new RequestedMovie();
	reqmovie.setImdbid(movie.getImdbid());
	reqmovie.setTitle(movie.getTitle());
	
	movieDAO.createRequestedMovie(reqmovie);
		
		
		JSONObject obj = new JSONObject();		

		PrintWriter out = response.getWriter();
		        out.println(obj);
			
		
	}

}
