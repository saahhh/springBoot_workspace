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
/*
	@Controller : view 템플릿 안에 들어있는 html과 상호작용할 수 있도록 제어하는 컨트롤러
	@RestController : DB에 받은 내용을 출력하거나 우리가 지정한 값을 화면에 보여줄수 있도록 해주는 컨트롤러
	 					이걸 쓰면 return "html파일"로 썼을 경우 실행되지 않음
*/


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
	
	
	@GetMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_form";
	}

	//delete GetMapping
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
}


/*
		@GetMapping("/update/{id}")
		public String updateProduct(@PathVariable Long id, Model model) {
			Optional<Product> product = productService.getProductById(id);
			product.ifPresent(value -> model.addAttribute("product", value));
			return "product_form";
		}
		
			Optional<Product> product = productService.getProductById(id);
			Optional : Optional 안에는 productService.getProductById(id)값을 가져와서 id에 해당하는 제품을 가지고 온다
			 			그런데 여기서 만약 id에 해당하는 제품이 존재하지 않는다면 Optional은 비어있게 된다
			 			만약에, Optional이 비어있게 된다면 에러가 발생할 수 있지만(현재는) 추후 비어있을 경우를 대비해서 예외값을 처리해주는 것이 좋음
			 				예외값을 처리하는 방법 :  orElse 를 이용해서 대체값을 제공하거나 페이지 이동 처리를 할 수 있다
			 									(ex. error.html)
			 									이 외에 orElseGet (orElseGet : 대체값을 생성하는 함수를 제공)
			 									 	  orElseThrow (orElseThrow : 예외를 던짐)도 있다
			product.ifPresent(value -> model.addAttribute("product", value));
			ifPresent : ifPresent은 Optional 객체 안에 값이 존재할 경우 람다식 표현을 실행하기 위한 메서드
						(ifPresent은 Optional 객체 안에 값이 존재할 경우 실행할 것이다)
						value 값이 존재하면 모델에 product변수명을 사용해서 product안에 value값을 추가할 것이다
						추가된 product는 html 템플릿 안에서 product를 thymeleaf를 통해 호출하여 value값을 사용할 수 있다
						
			람다식 : 
			간결하게 함수를 표현하는 방법으로 간단하게 결과를 표현할 때 사용
			 기본코드 (변수값) -> 변수값이 존재하거나 어떤일을 발생할 경우의 결과를 작성
			
			if(value != null){
				model.addAttribute("product", value)
			} 
			를 ifPresent(value -> model.addAttribute("product", value)); 로 간결하게 표현
			
			
*/





