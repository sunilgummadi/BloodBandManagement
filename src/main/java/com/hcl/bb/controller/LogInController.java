package com.hcl.bb.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
import com.hcl.bb.service.LoginService;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

@Controller
public class LogInController {

	@Autowired
	private LoginService loginService;
	
	private static final Logger logger= LogManager.getLogger(LogInController.class);
	
	@RequestMapping("login")
	public String LoginUser(Model model)
	{
		model.addAttribute("logInDetails",new User());
		logger.info("User entered in to LoginUser method of LoginService class");
		return "login";
	}
	
	@PostMapping("authenticate")
	public String authenticateUser(@ModelAttribute("logInDetails") User user,Model model,HttpServletRequest request)
	{
		try {
			logger.info(user.getUserName()+" entered in to authenticateUser method of LoginController class");
			loginService.validateUserLogin(user);
		    User userObject=loginService.validateUser(user);
		    request.getSession().setAttribute("user",userObject);
		    logger.info(user.getUserName()+" has logged in successfully!!");
		    return "redirect:/home";
		} catch (ApplicationException e) {
			  model.addAttribute("error",e.getMessage());
			  logger.info("Exception Occurred in auntenticateUser method of LoginController class:"+e.getMessage());
			  return "login";
		}
		
	}
}
