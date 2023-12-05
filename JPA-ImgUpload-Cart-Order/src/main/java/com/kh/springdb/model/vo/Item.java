package com.kh.springdb.model.vo;

import jakarta.persistence.*;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item {
	
	//primarykey
	private int id;
	
	//상품 이름
	private String name;	
	
	//상품 설명
	private String description;
	
	//상품 가격
	private int price;
	
	//판매 개수
	private int count;
	
	//재고
	private int stockQuantity;
	
	//상품 상태(판매중인지 품절인지 체크해주는 필드)
	private boolean isSale;
		
	//상품을 판매하는 판매자가 여러명일 수 있으므로 판매자가 누구인지 아이디를 넣어줘야한다
	//판매자 아이디(admin)
	@ManyToOne //판매자 한명이 여러개의 상품을 팔 수 있기 때문에  판매자 1 : 상품 N (판매자한테 상품은 하나) 
	@JoinColumn(name="admin_id")
	private Admin admin;
	
	//상품 사진
	private String photo;
	
	private List<카트에 담긴 상품들> cart_items = new ArrayList<>();
	
}
