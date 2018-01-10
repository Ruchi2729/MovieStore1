package com.neu.myStore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.MovieDAO;
import com.neu.myStore.dao.UserDAO;
import com.neu.myStore.pojo.Movie;



@Controller
@RequestMapping("/addMovie.htm")
public class AddMovieController {
	
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDAO;
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) 
	{ 
		
return "addMovie";
    } 
	
	@RequestMapping(method=RequestMethod.POST)
    public String addingMovieForm(HttpServletRequest request, HttpServletResponse response)   
	{ 
	Movie movie=(Movie) request.getSession().getAttribute("movie");
	movie.setPrice(Integer.parseInt(request.getParameter("price")));
	movie.setAvailability(true);
	movieDAO.create(movie);
	request.setAttribute("action1","success");
	
	   
return "addMovie";
    } 

}
