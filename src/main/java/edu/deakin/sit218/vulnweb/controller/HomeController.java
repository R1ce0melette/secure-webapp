package edu.deakin.sit218.vulnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showLogin() {
		return "home";
	}
	
	@GetMapping("/post-login")
	public String postLogin() {
		return "post-login";
	}
}
