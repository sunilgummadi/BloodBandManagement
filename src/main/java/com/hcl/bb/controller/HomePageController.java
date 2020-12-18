package com.hcl.bb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.model.User;
import com.hcl.bb.service.DonateBloodService;
import com.hcl.bb.service.DonationStatus;
import com.hcl.bb.service.RequestBloodService;
import com.hcl.bb.service.RequestStatusService;
import com.hcl.bb.service.SearchService;
/**
 * 
 * @author GummadiSunilKumar (51897413), KanumuriSaketh (51897445)
 *
 */
@Controller
public class HomePageController {

	@Autowired
	private RequestBloodService requestBloodService;

	@Autowired
	private DonateBloodService donateBloodService;

	@Autowired
	private RequestStatusService requestStatusService;

	@Autowired
	private DonationStatus donationStatus;
	
	@Autowired
	private SearchService searchService;
	
	private static final Logger logger= LogManager.getLogger(LogInController.class);


	@RequestMapping("home")
	public String home(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			logger.info(user.getUserName()+" entered in to home method of HomePageController class");
			model.addAttribute("user", request.getSession().getAttribute("user"));
			model.addAttribute("initialMessgae","Welcome");
			return "home";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping("requestFront")
	public String requestBloodFront(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			logger.info(user.getUserName()+ " entered in to requestBloodFront method of HomePageController class");
			model.addAttribute("requestBlood", new RequestBlood());
			return "request_blood";
		} else {
			return "redirect:/login";
		}

	}

	@PostMapping("addRequest")
	public String addRequest(@ModelAttribute("requestBlood") RequestBlood requestBlood, Model model,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			try {
				
				logger.info(user.getUserName()+" entered in to addRequest method HomePageController class");
				requestBloodService.validateFields(requestBlood);
				requestBloodService.addRequest(requestBlood, user);
				return ("request-success");
			} catch (ApplicationException e) {
				model.addAttribute("error", e.getMessage());
				logger.info("An exception occurred at addRequest method of HomePageController class:"+e.getMessage());
				return "request_blood";
			}
		} else {
			return "redirect:/login";

		}

	}

	@RequestMapping("donarFront")
	public String donoarFront(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
        
		if (user != null) {
			logger.info(user.getUserName()+" entered in to donarFront method of HomePageController class");
			model.addAttribute("donationDetails", new DonateBlood());
			return "donate_blood";
		} else {
			return "redirect:/login";
		}

	}

	@PostMapping("addDonar")
	public String addDonar(@ModelAttribute("donationDetails") DonateBlood donateBlood, Model model,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			try {
				logger.info(user.getUserName()+" entered in to addDonar method of HomePageController");
				donateBloodService.validateDetails(donateBlood);
				donateBloodService.addDonar(donateBlood, user);
				return "donar-success";

			} catch (ApplicationException e) {
				model.addAttribute("error", e.getMessage());
				logger.info("An exception occurred at addDonar method of HomePageController class."+e.getMessage());
				return "donate_blood";
			}
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping("requestStatus")
	public String requestStatus(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			
			logger.info(user.getUserName()+" entered in to requestStatus method of HomePageController.");
			List<RequestBlood> requestStatusList = requestStatusService.getRequestList(user);
			
			if (requestStatusList.size() > 0) {
				model.addAttribute("requestList", requestStatusList);
				logger.info("requestStatusList size is greater than zero");
				return "request_status";
			} else {
				model.addAttribute("message", "You haven't raised any request yet");
			    logger.info("requestStatusList size is less than zero");
				return "request_status";
			}
		}

		else {
			return "redirect:/login";
		}

	}

	@RequestMapping("donationStatus")
	public String donationStatus(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			List<DonateBlood> donationStatusList = donationStatus.getDonationList(user);
            logger.info(user.getUserName()+" entered in to donationStatus method of HomePageController class");
			if (donationStatusList.size() > 0) {
				model.addAttribute("donationList", donationStatusList);
				logger.info("donationStatusList size is greater than zero");
				return "donation_status";
			} else {
				model.addAttribute("message","You haven't donated yet. Donating blood periodically keeps you healthy.");
				logger.info("donationStatusList size is less than zero");
				return "donation_status";
			}
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("getResults")
	public String getSearchResults(@RequestParam("search")String searchQuery,Model model)
	{
		List<DonateBlood> searchQueryList=searchService.getSearchResults(searchQuery);
		logger.info("user entered in to getSearchResults method of HomePageController class");
		if(searchQueryList.size()>0)
		{
			model.addAttribute("searchQueryList",searchQueryList);
			return "home";
		}
		else
		{
			model.addAttribute("message","No results Found");
			return "home";
		}
	}
}
