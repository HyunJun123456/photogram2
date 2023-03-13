package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaToJspController {
	@GetMapping("/jsp/java")
	public String javaToJsp() {
		return "d";
	}
}
