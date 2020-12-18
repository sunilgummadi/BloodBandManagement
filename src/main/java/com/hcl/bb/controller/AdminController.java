package com.hcl.bb.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.Admin;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.service.AdminService;
/**
 * MokaSaiSuryaPrakash (51897451)
 */
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	private static final Logger logger= LogManager.getLogger(AdminController.class);

	@RequestMapping("adminFront")
	public String adminLogin(Model model) {
		model.addAttribute("Adminlogin", new Admin());
		logger.info("Admin entered in to the adminLogin method of the class AdminController");
		return "admin_login";
	}

	@PostMapping("adminValid")
	public String validateAdmin(@ModelAttribute("Adminlogin") Admin admin, Model model,HttpServletRequest request) {
		try {
			adminService.validateAdmin(admin);
			request.getSession().setAttribute("admin",admin);
			logger.info("Admin entered in to the validateAdmin method of the class AdminController and the admin has successfully logged in to the account");
			return "redirect:/adminRequestList";
			
		} catch (ApplicationException e) {
			model.addAttribute("error", e.getMessage());
			logger.info("Admin entered invalid credentials");
			return "admin_login";
		}

	}
	
	@RequestMapping("adminRequestList")
	public String getRequestList(Model model,HttpServletRequest request)
	{
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		logger.info("Admin entered into getRequestList method of AdminController Class");
		if(admin!=null)
		{
			List<RequestBlood> requestAdminList=adminService.getRequestList();
			if(requestAdminList.size()>0)
			{
				logger.info("requestAdminList size is greater than zero");
				model.addAttribute("requestAdminList",requestAdminList);
				return "admin_home";
			}
			else
			{
				logger.info("requestAdminList size is less than zero");
				model.addAttribute("message","No accept requests to show.");
				return "admin_home";
			}
			
		}
		else
		{
			return "redirect:/adminFront";
		}
	}

	
	@RequestMapping("approveRequest/{patientId}")
	public String approveRequest(@PathVariable("patientId") long patientId,HttpServletRequest request)
	{ 
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		logger.info("Admin entered in to approveRequest method of AdminControllerClass");
       if(admin!=null)
       {
    	adminService.acceptRequest(patientId);
   		return "redirect:/adminRequestList";
       }
       else
       {
    	   return "redirect:/adminFront";
       }
		
	}
	
	@RequestMapping("rejectRequest/{patientId}")
	public String rejectRequest(@PathVariable("patientId") long patientId,HttpServletRequest request)
	{ 
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		logger.info("Admin entered in to rejectRequest method of AdminController class");
	    if(admin!=null)
	    {
	    	adminService.rejectRequest(patientId);
			return "redirect:/adminRequestList";
	    }
	    else
	    {
	    	return "redirect:/adminFront";
	    }
		
	}
	
	@RequestMapping("adminDonarList")
	public String getDonarList(Model model,HttpServletRequest request)
	{
		Admin admin=(Admin)request.getSession().getAttribute("admin");
        logger.info("Admin entered in to getDonarList method of AdminController class");
		if(admin!=null)
		{
			List<DonateBlood> donateAdminList=adminService.getDonarList();
			if(donateAdminList.size()>0)
			{
				logger.info("donateAdminList size is greater than zero");
				model.addAttribute("donateAdminList",donateAdminList);
				return "admin_donar";
			}
			else
			{
				logger.info("donateAdminList size is less than zero");
				model.addAttribute("message","No accept requests to show.");
				return "admin_donar";
			}
		}
		else
		{
			return "redirect:/adminFront";
		}
		
	}
	
	@RequestMapping("approveDonar/{patientId}")
	public String acceptDonar(@PathVariable("patientId") long patientId,HttpServletRequest request)
	{ 
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		logger.info("Admin entered in to acceptDonar method of AdminController class");
        if(admin!=null)
        {
		adminService.acceptDonar(patientId);
		return "redirect:/adminDonarList";
        }
        else
        {
			return "redirect:/adminFront";

        }
	}
	
	@RequestMapping("rejectDonar/{patientId}")
	public String rejectDonar(@PathVariable("patientId") long patientId,HttpServletRequest request)
	{ 
		Admin admin=(Admin)request.getSession().getAttribute("admin");
        logger.info("Admin entered in to rejectDonar method of AdminController class");
		if(admin!=null)
		{
			adminService.rejectDonar(patientId);
			return "redirect:/adminDonarList";
		}
		else
		{
			return "redirect:/adminFront";

		}
		
	}

}