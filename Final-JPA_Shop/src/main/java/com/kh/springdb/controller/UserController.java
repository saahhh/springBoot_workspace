package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping()
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String signUp(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@GetMapping("/signup")
	public String signUp(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordCorrect", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "signup_form";
		}
		userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
			return "redirect:/";

	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
	
}
