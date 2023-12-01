package com.kh.spring.shop.service;

import com.kh.spring.shop.repository.ProductRepository;
import com.kh.spring.shop.vo.Cart;
import com.kh.spring.shop.vo.Order;
import com.kh.spring.shop.vo.Product;

public class ShopService {
	//최종적으로 만들어준 order 와 cart 정보를 가지고 결제를 하거나 장바구니에 상품을 추가해서 주문을 생성해주는 메서드들을 넣어줄 것
	public Cart cart = new Cart();	
	
	public ProductRepository productRepository;
	
	public Order placeOrder(Product product, int quantity) {
		//장바구니에 상품 추가
		cart.addToCart(product, quantity);
		
		//주문번호 생성
		Order order = createOrder(product, quantity);
		
		//만약에 데이터베이스에 주문정보를 저장하고 반활할 수 있으므로 saveOrder(order);
		
		return order;	
	}
	
	//주문정보 생성 메서드
	public Order createOrder(Product product, int quantity) {
		Order order = new Order();
		order.setProduct(product);
		order.setQuantity(quantity);
		return order; //주문정보를 반환
	}
	
	//주문정보 조회 메서드
	public Order getOrderById(Long orderId) {
		Order order = new Order();
		order.setId(orderId);
		order.setProduct(getProductById(orderId));
		//주문한 수량 추가
		return order;
	}
	
	//상품정보 조회 메서드
	public Product getProductById(Long productId) {
		return productRepository.getProductById(productId);
		
	}
	
	//결제처리 메서드
	
}
