package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //@NotNull로 표시된 필드를 사용해서 생성자를 생성한다
public class ItemController {

	// @NotNull로 표시된 필드를 사용해서 생성자를 생성
		private final ItemService itemService;
		
	    @GetMapping("/")
	    public String mainPageNoneLogin(Model model) {
	        // 로그인을 안 한 경우
	        List<Item> items = itemService.allItemView();
	        model.addAttribute("items", items);

	        return "/index";
	    }

	    // 상품 등록 페이지 - 판매자만 가능
	    @GetMapping("/item/new")
	    public String itemSaveForm(Model model) {
	            return "addItemForm";
	      
	    }

	    // 상품 등록 (POST) - 판매자만 가능
	    @PostMapping("/item/new")
	    public String itemSave(Item item, MultipartFile imgFile) throws Exception {
	     
	            itemService.saveItem(item, imgFile);
	            return "redirect:/";
	       
	    }
		
	}
	
	
	/*
	private final ItemService itemService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		//import java.util.List;
		List<Item> items = itemService.allItemView();
		model.addAttribute("items", items);
		//view 템플릿 html과 연결하기 위해서 작성되는 페이지
		return "/index";
	}
	
	@GetMapping("/items")	
	public String allItemList(Model model) {
		List<Item> items = itemService.allItemList();
		model.addAttribute("items", items);
		return "itemList";
		
	}
	
	/*
	@GetMapping("/item/list")
	public String itemList(Model model, @PageableDefault(size=12) Pageable pageable, @RequestParam(name="keyword", required=false) String keyword) {
		//페이지네이션 처리를 위한 서비스
		//검색을 하지 않고 페이징처리를 원함
		//Page<Item> items = itemService.getItemByPage(pageable);
		return "itemList";
	}
	* /
	
	//@GetMapping 상품 등록 페이지 //admin만 등록할 수 있게 수정
	@GetMapping("/new")
	public String additemForm(Model model) {
		
		return "나중에 작성해줄 템플릿.html";
	}
	
	//@PostMapping 상품 등록으로 입력된 값을 DB에 보내기 //admin만 등록할 수 있게 수정
	
	@PostMapping("/save")
	public String Item(Item item, MultipartFile photoFile) throws IllegalStateException, IOException {
		//MultipartFile을 이용해서 상품을 등록할 때 이미지 파일도 같이 등록될 수 있도록 파라미터를 생성해줌
		//itemService.addItem(item); //이미지 없이 상품을 등록하고 싶다면 item만 작성해도 되지만
		//이미지 또한 포함해서 상품을 등록하고 싶다면 item, photoFile을 추가해서 작성
		itemService.addItem(item, photoFile);
		return "redirect:/itemList";
	}
	
	//상품 상세
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("item", itemService.getItemById(id));
		return "viewItem";
	}
	
	//수정
	

	
	//삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		itemService.itemDelete(id);
		return "itemList";
	}*/


