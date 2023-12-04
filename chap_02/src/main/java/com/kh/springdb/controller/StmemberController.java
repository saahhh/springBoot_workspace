package com.kh.springdb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.service.StmemberService;
import com.kh.springdb.vo.STMember;

@Controller
@RequestMapping("/member")
public class StmemberController {
	
	private StmemberService stService;
	
	@Autowired
	public StmemberController(StmemberService stService) {
		this.stService = stService;
	}
	
	@GetMapping
	public String getAllMember(Model model) {
		model.addAttribute("members", stService.getAllMember());
		return "memberList";
	}
	
	//insert
	@GetMapping("/new")
	public String showMemberForm(Model model) {
		model.addAttribute("member", new STMember());
		return "memberForm";
	}
	
	@PostMapping("/save")
	public String saveMember(@ModelAttribute STMember stmember) {
		stService.saveMember(stmember);
		return "redirect:/members";
	}	

	//update
	@GetMapping("/update/{memberId}")
	public String updateMember(@PathVariable Long id, Model model) {
		//Optional 이용해서 id값 가지고오기
			//Service에 findById 관련 메서드 작성하기
		Optional<STMember> stmember = stService.getMemberById(id);
		
		//람다식 사용해서 값이 존재할 경우 member의 값을 추가하는 코드 작성
		stmember.ifPresent(value -> model.addAttribute("member", value));
		return "memberForm";
	}
	
	//delete
	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable Long id) {
		stService.deleteMemberById(id);
		return "redirect:/members";
	}
	

}
