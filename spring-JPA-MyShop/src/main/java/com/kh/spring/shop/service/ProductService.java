package com.kh.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kh.spring.shop.repository.ProductRepository;
import com.kh.spring.shop.vo.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	//모든 상품을 조회하는 메서드 Repository 안에 내장되어 있는 findAll이라는 지정된 메서드를 가지고와서 사용되는 것
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	//상품 1개만 조회하는 메서드
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	
	//저장하는 메서드
	//최초로 작성한 내용 저장, 기존에 작성한 내용 수정해서 저장
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//삭제하는 메서드
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
}