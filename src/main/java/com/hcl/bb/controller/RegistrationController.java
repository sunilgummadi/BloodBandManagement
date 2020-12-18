package com.hcl.bb.controller;

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
import com.hcl.bb.service.RegistrationService;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	private static final Logger logger= LogManager.getLogger(RegistrationController.class);

	@RequestMapping("front")
	public String addUserFront(Model model)
	{
		logger.info("User entered in to addUserFront method of RegistrationController");
		model.addAttribute("userDetails",new User());
		return "userregn";
	}
	
	@PostMapping("add")
	public String addUser(@ModelAttribute("userDetails") User user,Model model)
	{
		logger.info(user.getUserName()+"Entered in to addUser method of RegistrationController");
		try {
			registrationService.validateUser(user);
			registrationService.doesUserExists(user);
			registrationService.addUser(user);
			logger.info("User with username "+user.getUserName()+" has been successfully created");
			return "registered";
			
		} catch (ApplicationException e) {
			model.addAttribute("error",e.getMessage());
			logger.info("Exception Occurred:"+e.getMessage());
			return "userregn";
		}
		
	}
}
