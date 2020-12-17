package com.hcl.bb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

@Controller
public class MainPageController {

	@GetMapping("/")
	public String home()
	{
		return "main";
	}
}
