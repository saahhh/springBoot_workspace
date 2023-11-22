package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springdb.service.ProductCommentService;

@Controller
public class ProductCommentController {
	
	@Autowired
	private ProductCommentService productcommentService;
	
	@GetMapping("productCommentList")
	public String displayProductCommentList(Model model) {
		model.addAttribute("productcomments", productcommentService.getAllProductComments());
		return "productCommentList";
	}
}
