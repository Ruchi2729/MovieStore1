package com.neu.myStore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



@org.springframework.stereotype.Controller
@RequestMapping("/launchPage.htm")
public class LaunchController  {
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) 
	{ 
		//Configuration cfg = new Configuration();
	    //SessionFactory sf = cfg.configure().buildSessionFactory();
	   
return "launch";
    } 
	
	
	

	

}
