package com.kh.ThymeSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "안녕~ 나는 ThymeLeaf야");
		return "hello";
				
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model) {
		model.addAttribute("message", "안녕");
		return "hello2";
	}
}
