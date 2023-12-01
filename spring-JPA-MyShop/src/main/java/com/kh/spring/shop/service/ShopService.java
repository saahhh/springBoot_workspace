package com.kh.spring.shop.service;

import com.kh.spring.shop.repository.OrderRepository;
import com.kh.spring.shop.repository.PaymentRepository;
import com.kh.spring.shop.repository.ProductRepository;
import com.kh.spring.shop.vo.Cart;
import com.kh.spring.shop.vo.Order;
import com.kh.spring.shop.vo.Payment;
import com.kh.spring.shop.vo.Product;

public class ShopService {
	//최종적으로 만들어준 order 와 cart 정보를 가지고 결제를 하거나 장바구니에 상품을 추가해서 주문을 생성해주는 메서드들을 넣어줄 것
	public Cart cart = new Cart();	
	
	private ProductRepository productRepository; //sql문은 보안이 중요하기 때문에 private으로 선언해주는 것이 좋다
	private PaymentRepository paymentRepository;
	private OrderRepository orderRepository;
	
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
		/*Order order = new Order();
		order.setId(orderId);
		order.setProduct(getProductById(orderId));
		//주문한 수량 추가
		return order; 부분 대신 아래 구문으로!!*/
		return orderRepository.findById(orderId).orElse(null);
	}
	
	//상품정보 조회 메서드
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElse(null);	
		//.orElse(null) : Optional 대신 쓰는 방법
	}
	
	//결제처리 메서드
	private Payment savePayment(Order order, String payment) {
		//결제에 대한 정보 처리
		Payment payments = new Payment();
		payments.setOrder(order);
		payments.setPaymentStatus(payment);
		return payments;
		
	}
	
}
