package com.kh.spring.shop.controller;

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

import com.kh.spring.shop.service.ProductService;
import com.kh.spring.shop.vo.Member;
import com.kh.spring.shop.vo.Product;



@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	//모든 제품을 보기 위한 제품 List 확인 메서드
	@GetMapping
	public String getAllProducts(Model model){
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "productList";
	
	}
	
	//제품 상세보기 메서드
	@GetMapping("/details/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("products", value));
		return "productDetail";
	}
	
	
	//작성한 내용을 저장하기 위한 메서드
	//save @GetMapping : 작성할 url을 불러오기 위한 주소값 설정
	@GetMapping("/new")	
	public String displayProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";		
	}
	//save @PostMapping : 작성할 내용을 저장할 url 설정
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	
	@GetMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "productForm";
	}

	//delete GetMapping
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
}
