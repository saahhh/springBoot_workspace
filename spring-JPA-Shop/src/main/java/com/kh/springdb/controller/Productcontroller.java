package com.kh.springdb.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.kh.springdb.service.ProductService;
import com.kh.springdb.vo.Product;


@Controller //최종적으로 return하는 건 html파일
//@RestController //view(html파일)로 안감


@RequestMapping("/products")
public class Productcontroller {
	
	private final ProductService productService;
	
	@Autowired
	public Productcontroller(ProductService productService) {
		this.productService = productService;
	}
	
	//모든 제품을 보기 위한 제품 List 확인 메서드
	@GetMapping
	public String getAllProducts(Model model){
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "product_list";
		//return productService.getAllProduct();
	}
	
	//제품 상세보기 메서드
	@GetMapping("/details/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("products", value));
		return "product_detail";
	}
	
	//작성한 내용을 저장하기 위한 메서드
	//save @GetMapping : 작성할 url을 불러오기 위한 주소값 설정
	@GetMapping("/new")	
	public String displayProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "product_form";		
	}
	//save @PostMapping : 작성할 내용을 저장할 url 설정
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	//
	//delete GetMapping
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
}
