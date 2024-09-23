package edu.deakin.sit218.vulnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	// Add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
