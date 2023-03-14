package com.cos.photogramstart.webtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpResponseController {
	@GetMapping("/txt")
	public String txt() {
		return "a.txt";
	}
	
	@GetMapping("/mustache")
	public String mustache() {
		return "b";
	}
	
	@GetMapping("/jsp")
	public String jsp() {
		return "c";
	}
	
}
