package com.neu.myStore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.myStore.dao.UserDAO;
import com.neu.myStore.pojo.User;



@org.springframework.stereotype.Controller
@RequestMapping("/registerUser.htm")
public class UserRegistartionController {
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public String actionController(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request, HttpServletResponse response)   
	{ 
        
   user.getFirstname().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
   user.getLastname().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
   user.getPassword().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
   user.getUsername().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();     
   user.getAddress().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim(); 
   
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "registerU";
		}

		try {
			if(request.getParameter("usertype").equalsIgnoreCase("admin"))
			{
				user.setAcountType(User.AccountType.Admin);
				request.setAttribute("action1", "adminexists");
				return "registerU";
			}
			else
			{
				user.setAcountType(User.AccountType.AccountHolder);
				if(userDao.checkUser(user.getUsername()))
						{
					request.setAttribute("action1", "userexists");
					return "registerU";
						}
			}
			user.setFavGenre(request.getParameter("selectedg"));
			System.out.println("favgenre"+user.getFavGenre());
			userDao.create(user.getUsername(), user.getPassword(), user.getEmail().getEmailId(), user.getFirstname(), user.getEmail().getEmailId(), user.getAddress(),user.getAcountType(),user.getFavGenre());
			request.setAttribute("action1", "success");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "registerU";
	}
		

	
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request, HttpServletResponse response) 
	{ 
		
return "registerU";
    } 

}
