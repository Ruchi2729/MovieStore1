package com.neu.myStore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.UserDAO;

@Controller
@RequestMapping("/loginOutPage.htm")
public class LogOutController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(HttpServletRequest request, HttpServletResponse response) 
	{ request.getSession().invalidate();
	if(userDao.getSession().isOpen())
		userDao.getSession().clear();
		request.setAttribute("actionName", "logout");
return "registerRequest";
    } 

}
