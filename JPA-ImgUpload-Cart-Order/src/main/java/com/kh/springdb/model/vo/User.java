package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;


//@RequiredArgsConstructor : final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줌
@Builder
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만들어줌
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 만들어줌
@Getter
@Setter
@Entity // DB에 테이블 자동 생성
public class User {

	@Id
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName="user_seq",allocationSize=1)
	@Column(name = "id")
	private int id;

	 @Column(unique = true) // 닉네임 중복 안됨
	 private String username;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String role; // 권한 (회원 / 관리자)
	
	private int coin; // 구매자 - 충전한 돈 / 판매자 - 수익
	
	// 판매자가 가지고 있는 상품들
	@OneToMany(mappedBy = "seller")
	private List<Item> items = new ArrayList<>();
	
	// 구매자의 장바구니
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	// 구매자의 주문
	@OneToMany(mappedBy = "user")
	private List<Order> userOrder = new ArrayList<>();
	
	// 구매자의 주문상품들
	@OneToMany(mappedBy = "user")
	private List<OrderItem> userOrderItem = new ArrayList<>();
	
	// 판매자의 판매상품들
	@OneToMany(mappedBy = "seller")
	private List<SaleItem> sellerSaleItem = new ArrayList<>();
	
	// 판매자의 판매
	@OneToMany(mappedBy = "seller")
	private List<Sale> sellerSale;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate; // 날짜
	
	@PrePersist // DB에 INSERT 되기 직전에 실행. 즉 DB에 값을 넣으면 자동으로 실행됨
	public void createDate() {
	   this.createDate = LocalDate.now();
	}
}


/*
 @Builder

//모든 필드값을 파라미터로 받을 수 있는 생성자 만들어줌
@AllArgsconstructor //Admin ad = new Admin(Admin 클래스 안에 있는 필드 모두 생성);
//파라미터가 없는 기본 생성자 만들기
@NoArgsConstructor //Admin ad = new Admin();를 @NoArgsConstructor로 대체해주는 것

@Getter
@Setter
public class User {
	//Admin ad = new Admin();
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private int id;
	
	@Column(unique = true) //닉네임 중복되지 않도록 설정해주는 것
	private String username;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String role; //관리자인지 확인하기 위한 권한 설정
	
	private int pay; //pay는 구매자가 충전한 금액, 판매자는 판매한 금액으로 표시
	
	/*** 구매자를 위한 필드 * /
	//구매자용 장바구니
	private Cart cart;
	
	//구메자가 주문한 리스트
	private List<Order> order = new ArrayList<>();
	
	//구매자가 주문한 주문상품리스트
	private List<Order> orderItem = new ArrayList<>();
	
	
	/*** 판매자를 위한 필드 * /
	//판매자 상품리스트
	private List<판매상품아이템> 판매상품변수명 = new ArrayList<>();
	
	//판매 리스트
	private List<판매> 판매에대한변수명;
	
	//주문날짜와 판매날짜
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	
	/*** 구매자와 판매자를 위한 필드 * /
	//DB에 판매자나 구매자가 구매한 기록보다 먼저 날짜가 들어가면 안되기 때문에 
	//미리 데이터베이스에 넣어줄 날짜 값을 미리 생성
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
*/
  