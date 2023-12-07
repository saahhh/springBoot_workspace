package com.kh.springdb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

*/
public class User {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private int id;
	
	//닉네임 중복 방지를 위해 unique 설정
	@Column(unique=true)
	private String username;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String role; //회원인지 관리자인지 권한 주는것
	
	private int coin;
	
	
	//판매자가 가지고 있는 상품
	private List<Item> items = new ArrayList<>();
	
	
	//판매자가 판매한 내역 //Sale을 만든 후 주석 해지
	//@OneToMany(mappedBy="seller")
	//private List<Sale> sellerSale;
	
	//판매자가 판매한 상품들 //SaleItem을 만든 후 주석 해지
	//@OneToMany(maaperdBy="seller")
	//private List<SaleItem> sellerSaleItem = new ArrayList<>();
	
	
	//구매자 결제 내역
	
	//구매자 주문 리스트
	
	//구매자가 사고싶은 내역의 장바구니
	//Cart라는 장바구니를 이용해서 장바구니에 아이템을 담을 예정
	*/
}
