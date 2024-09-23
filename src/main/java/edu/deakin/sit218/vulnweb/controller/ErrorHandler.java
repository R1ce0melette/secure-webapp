package edu.deakin.sit218.vulnweb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	//static Logger logger = Logger.getLogger(CoachController.class.getName());
	//@ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(Exception.class)
    public String handleConflict(Model theModel, Exception ex) {
		theModel.addAttribute("err","Catching with global error handler");
		theModel.addAttribute("details",ex.toString());
		return "error";
    }
}