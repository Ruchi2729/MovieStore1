package com.neu.myStore.controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.MovieDAO;
import com.neu.myStore.pojo.Movie;
import com.neu.myStore.pojo.RequestedMovie;
import com.neu.myStore.pojo.Review;
import com.neu.myStore.pojo.User;

import antlr.collections.List;

@Controller
public class MovieDetailController {
	
	
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDAO;
	
	@RequestMapping(value="/movieDetailPage.htm",method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) 
	{ 
		try
		{
		Movie movie1  =(Movie)request.getSession().getAttribute("movie");
		
		Movie movie=movieDAO.get(movie1.getImdbid());
		ArrayList<String> users=movieDAO.getUserNames(movie);
		
		request.setAttribute("moviename", movie.getTitle());
		request.setAttribute("poster",movie.getPoster());
		request.setAttribute("imdbRating", movie.getIMDBrating());
		request.setAttribute("noofuserswholike",users.size());
		request.setAttribute("users",users);
	java.util.List<Review> reviews = movieDAO.getReview(movie);
	
	System.out.println(reviews);
	request.setAttribute("moreview",reviews);
		int rating=0;
		for(Review review:reviews)
		{
			rating=rating+review.getRating();
		}
		rating=(rating)/(reviews.size());
		request.setAttribute("avgrating",rating);
		request.setAttribute("error","see the movies details below");
		
		}
		catch(Exception e)
		{
			request.setAttribute("error","error occurred to show the movie.Please search the movie");
		}
		
		
		
		
		
return "showMovie";
    }
	
	//To show information of movies from suggested movies
	@RequestMapping(value="/movieDetailPage2.htm",method=RequestMethod.GET)
    public String showMovie2(HttpServletRequest request, HttpServletResponse response) 
	{ 
		try{
		Movie movie  =movieDAO.get(request.getParameter("moimdb"));
		int size=0;
		try{
		ArrayList<String> users=movieDAO.getUserNames(movie);
		size=users.size();
		}
		catch(NullPointerException e)
		{
			
		}
		
		request.setAttribute("moviename", movie.getTitle());
		request.setAttribute("poster",movie.getPoster());
		request.setAttribute("imdbRating", movie.getIMDBrating());
		request.setAttribute("noofuserswholike",size);
		ArrayList<String> users=movieDAO.getUserNames(movie);
		request.setAttribute("users",users);
	java.util.List<Review> reviews = movieDAO.getReview(movie);
	System.out.println(reviews);
	request.setAttribute("moreview",reviews);
		int rating=0;
		for(Review review:reviews)
		{
			rating=rating+review.getRating();
		}
		rating=(rating)/(reviews.size());
		request.setAttribute("avgrating",rating);
		}
		catch(Exception e)
		{
			
		}
		
return "showMovie";
    }
	
	
	@RequestMapping(value="/suggestionPage.htm",method=RequestMethod.GET)
    public String showAllMovies(HttpServletRequest request, HttpServletResponse response) 
	{ 
		User us = (User)request.getSession().getAttribute("user");
		java.util.List<Movie> sugmovies=movieDAO.getMovieListForGenre(us.getFavGenre());
		//int movieCount=0;
//		for( Movie mov:sugmovies)
//		{
//			//movieCount=movieCount+1;
			request.setAttribute("movieList",sugmovies);
//			if(movieCount==3)
//			{
//				break;
//			}
//		
		//}
		
		
		
return "showSuggestedMovies";
    } 
	
	
	@RequestMapping(value="/showRequestedMovies.htm",method=RequestMethod.GET)
    public String showAllRequestedMovies(HttpServletRequest request, HttpServletResponse response) 
	{ 
		//User us = (User)request.getSession().getAttribute("user");
		java.util.List<RequestedMovie> reqmovies=movieDAO.getRequestedMovies();
		//int movieCount=0;
//		for( Movie mov:sugmovies)
//		{
//			//movieCount=movieCount+1;
			request.setAttribute("reqmovieList",reqmovies);

		
		
		
return "showRequestedMovies";
    } 
	

}
