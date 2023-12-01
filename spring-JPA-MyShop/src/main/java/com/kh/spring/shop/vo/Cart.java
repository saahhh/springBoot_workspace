package com.kh.spring.shop.vo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	//장바구니
	//장바구니가 얼마나 들어있는지
	
	//장바구니에 담긴 CartItem들을 저장하는 목록
	private List<CartItem> items = new ArrayList<>();
	
	//장바구니에 담긴 목록을 반환하는 메서드
	public List<CartItem> getItems(){
		return items;
	}
	
	//장바구니에 제품을 추가하는 메서드로 제품과 수량을 입력받은 내용을 메서드에 담긴위해 파라미터에 (Product product, int quantity)으로 제품과 수량에 관련된 파라미터를 작성해준것
	public void addToCart(Product product, int quantity) {
		//장바구니에 이미 담겨져있는 CartItem들을 확인하기 위한 반복문을 설정
		for(CartItem item : items) {
			//만약에 장바구니에 담긴 제품과 현재 추가하려는 제품이 동일하다면
			if(item.getProduct().getId().equals(product.getId())) {
			//해당 제품의 수량을 추가하려는만큼 증가시킨다
			item.setQuantity(item.getQuantity() + quantity);
			return;
		}
	}
	
	//장바구니에 추가하려는 제품이 장바구니에 존재하지 않거나 갯수가 달라질 수 있으므로 새로운 CartItem 객체를 생성해서 items에다가 새로운 CartItem을 장바구니에 추가한다
	CartItem newItem = new CartItem(product, quantity);
	items.add(newItem);
	}
	
}
