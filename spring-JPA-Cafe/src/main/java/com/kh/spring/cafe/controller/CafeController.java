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
	@Autowired
	private CafeService cafeService; //대문자는 다른곳에서 가져와서 사용하기위한 약속어, 소문자는 이 페이지 안에서만 사용할 것이기 때문
	
	
	//@RequestParam(required=false)String name : 파라미터를 필수로 적어주지 않아도 된다라는 뜻
	//@RequestParam : http요청으로 파라미터를 메서드의 매개변수로 전달할 때 사용한다
	//	클라이언트가 웹 애플리케이션에 보내는 요청에 파라미터 값을 받아서 처리하는데 사용한다
	
	/*
		@PathVariable 과 @RequestParam의 차이점
		@PathVariable : URL 경로에서 변수 값을 추출 url  /cafes/{id}
		@RequestParam : 한 경로안에서 요청한 클라이언트가 요청한 파라미터 값을 추출한다 url  /cafes?name=사용자가 폼에 입력한 값
		
	*/
	
	
	@GetMapping
	public String getAllCafes(Model model, @RequestParam(required=false)String name) { //@RequestParam(required=false)String name : String name이 필수가 아니라고 지정해주는 것
		//카페리스트를 만들어 준 후에 만약에 리스트에서 카페가 존재한다면 그 카페 목록들만 보여주고 만약에 존재하지 않는다면은 모든 카페 내용을 보여주겠다
		List<Cafe> cafes;
		if(name != null && !name.isEmpty()) {/*만약에 카페 이름값이 빈 값이 아니거나 null값이 아니라면*/
			cafes = cafeService.findCafes(name);
			/*사람들이 검색한 카페 내용을 service에서 가져와서 뿌린 다음에 cafes에 넣어주겠다*/	
		}else {
			cafes = cafeService.getAllCafes();
			/*모든 카페 리스트를 보여주겠다*/			
		}
		model.addAttribute("cafes", cafes); //"cafes"라는 이름으로 cafeService.getAllCafes())안에 넣어주겠다
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
	
}

	
	/*
	//키워드 검색
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		//특정 키워드를 포함하는 카페를 검색
		List<Cafe> cafes = cafeService.findCafeByName(keyword);
		
		//모델에 검색 결과를 추가
		model.addAttribute("cafes", cafes); //"cafes" view를 위한 cafes , cafes는 keyword에 대한 모든 검색 결과를 담음
		
		//검색 결과를 보여줄 페이지 리턴
		return "searchResults";
	*/
