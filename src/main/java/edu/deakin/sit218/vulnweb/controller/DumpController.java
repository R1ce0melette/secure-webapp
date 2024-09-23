package edu.deakin.sit218.vulnweb.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.deakin.sit218.vulnweb.entity.PayloadXSS;

@Controller
public class DumpController {
	static Logger logger = Logger.getLogger(DumpController.class.getName());
	private static final String UPLOAD_DIR = "/var/www/html/uploads/";
	
	@GetMapping("/xss")
	public String showXSS() {
		return "xss";
	}
	@GetMapping("/doxss")
	public String doXSS(@Valid @ModelAttribute("payload") PayloadXSS payload, 
			BindingResult validationErrors, Model model) {
		if (validationErrors.hasErrors()) {
			return "error";
		} else {
		model.addAttribute("payload", payload.toString());
		return "xss";
		}
	}

	@GetMapping("/sqli")
	public String showSQLi() {
		return "sqli";
	}

	@GetMapping("/postsqli")
	public String doSQLi(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		return "sqli";
	}

	@GetMapping("/fileUpload")
	public String showFile() {
		return "fileUpload";
	}

	@PostMapping("/fileUpload")
	public String doFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		if (file.isEmpty()) {
			model.addAttribute("message", "Failed to upload. The file was empty.");
			return "fileUpload";
		}
		// Check file extension
		String fileName = file.getOriginalFilename();
		if (!isValidExtension(fileName)) {
			model.addAttribute("message", "Invalid file type. Only .txt, .jpg, .png files are allowed.");
			return "fileUpload";
		}
		// Validate MIME type
		String mimeType = file.getContentType();
		if (!isValidMimeType(mimeType)) {
			model.addAttribute("message", "Invalid file type. File content does not match allowed types.");
			return "fileUpload";
		}
		
		Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename()); // set write path
		Files.write(path, file.getBytes()); // write file to path

		String fileUrl = "/uploads/" + file.getOriginalFilename(); // construct output message
		model.addAttribute("message", "File uploaded successfully. File URL: " + fileUrl);
		// model.addAttribute("message", "Upload endpoint reached.");
		return "fileUpload";
	}
	
	//Security feature for unrestricted file upload
	// Validate file extension (only .txt, .jpg, .png allowed)
	private boolean isValidExtension(String fileName) {
	    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	    return Arrays.asList("txt", "jpg", "png").contains(fileExtension);
	}

	// Validate MIME type (only text/plain, image/jpeg, and image/png allowed)
	private boolean isValidMimeType(String mimeType) {
	    return Arrays.asList("text/plain", "image/jpeg", "image/png").contains(mimeType);
	}

	@ExceptionHandler(Exception.class)
	public String errorHandler(Model theModel, Exception ex) throws SecurityException, IOException {
		FileHandler fh;
		fh = new FileHandler("/home/kali/webapp.log");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		theModel.addAttribute("err", "something went wrong, check the log");
		logger.log(Level.SEVERE, ex.toString());
		return "error";
	}
}
