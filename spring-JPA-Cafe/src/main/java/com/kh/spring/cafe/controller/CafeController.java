package com.kh.spring.cafe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.cafe.service.CafeService;
import com.kh.spring.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafes")
public class CafeController {
	private final CafeService cafeService; //대문자는 다른곳에서 가져와서 사용하기위한 약속어, 소문자는 이 페이지 안에서만 사용할 것이기 때문
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	@GetMapping
	public String getAllCafes(Model model) {
		//List<Cafe> cafes = cafeService.getAllCafes();
		model.addAttribute("cafes", cafeService.getAllCafes()); //"cafes"라는 이름으로 cafeService.getAllCafes())안에 넣어주겠다
		return "cafeList";
	}
	
	//카페 상세보기 
	@GetMapping("/datails/{cafeId}")
	public String getCafeDetails(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafes", value));
		return "cafeDetail";
	}
	
	//카페 추가
	@GetMapping("/new")
	public String showCafeForm(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	
	//카페 저장
	@PostMapping("/save")
	public String saveCafe(@ModelAttribute Cafe cafe) {
		cafeService.saveCafe(cafe);
		return "redirect:/cafes";
	}
	
	//카페 정보 수정
	@GetMapping("/update/{cafeId}")
	public String UpdateCafe(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafeForm";
	}
	
	//카페 하나만 삭제
	@GetMapping("/delete/{cafeId}")
	public String deleteCafeById(@PathVariable Long cafeId) {
		cafeService.deleteCafeById(cafeId);
		return "redirect:/cafes";
	}
	
	//카페 전체 삭제
	@GetMapping("/delete/all")
	public String deleteAllCafes() {
		cafeService.deleteAllCafes();
		return "redirect:/cafes";
	}
	
	//키워드 검색
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		//특정 키워드를 포함하는 카페를 검색
		List<Cafe> cafes = cafeService.findCafeByName(keyword);
		
		//모델에 검색 결과를 추가
		model.addAttribute("cafes", cafes); //"cafes" view를 위한 cafes , cafes는 keyword에 대한 모든 검색 결과를 담음
		
		//검색 결과를 보여줄 페이지 리턴
		return "searchResults";
	}
	
	
	
	
	
	
	
}
