package com.kh.springStart.springStart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class introController {
	@RequestMapping("/intro")
	public String getIntro() {
		return "Intro";
	}
}
