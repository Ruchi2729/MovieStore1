package com.neu.myStore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/loginPage.htm")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) 
	{ 
		
return "login";
    } 

}
