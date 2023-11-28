package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.ProductRepository;
import com.kh.springdb.vo.Product;

@Service
public class ProductService {
	//인터페이스를 사용해서 데이터베이스와 상호 작용하는 데 사용할 레포지토리
	//레포지토리를 나타내는 필드
	//final로 선언돼서 변경이 불가능
	//ProductRepository은 sql문을 가지고 오는애라 변경되서는 안됨
	private final ProductRepository productRepository;
	
	@Autowired //생성자를 위한 어노테이션으로 스프링은 ProductRepository 타입의 빈을 찾아서 주입한다
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	//모든 상품을 조회하는 메서드 Repository 안에 내장되어 있는 findAll이라는 지정된 메서드를 가지고와서 사용되는 것
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	//상품 1개만 조회하는 메서드
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	
	//저장하는 메서드
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//삭제하는 메서드
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
}

/*
Optional : 제품의 존재 여부를 체크할 수 있게 해주는 객체
	
	
*/
