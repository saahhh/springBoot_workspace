package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//공통으로 들어가는 url이 있다면 RequestMapping 사용해서 user로 묶어주기
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	//회원가입 창
	@GetMapping("/signup")
	public String singUp(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	//회원가입에 대한 PostMapping
	@PostMapping("/signup")
	public String signUp(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		//만약 패스워드 두개가 일치하지 않는다면 일치하지 않습니다 문구보여주기
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}
		userService.createUser(userCreateForm.getUsername(), userCreateForm.getPassword1(), userCreateForm.getEmail());
		return "redirect:/";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
}
