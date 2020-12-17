package com.hcl.bb.controller;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("login")
	public String LoginUser(Model model)
	{
		model.addAttribute("logInDetails",new User());
		return "login";
	}
	
	@PostMapping("authenticate")
	public String authenticateUser(@ModelAttribute("logInDetails") User user,Model model,HttpServletRequest request)
	{
		try {
			loginService.validateUserLogin(user);
		    User userObject=loginService.validateUser(user);
		    request.getSession().setAttribute("user",userObject);
		    return "redirect:/home";
		} catch (ApplicationException e) {
			  model.addAttribute("error",e.getMessage());
			  return "login";
		}
		
	}
}
