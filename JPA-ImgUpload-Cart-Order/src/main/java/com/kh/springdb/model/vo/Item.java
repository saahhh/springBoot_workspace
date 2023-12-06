package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1)
	private int id;
	
	//상품 이름
	private String name;	
	
	//상품 설명
	private String text;
	
	//상품 가격
	private int price;
	
	//판매 개수
	private int count;
	
	//재고
	 private int stock;
	
	//상품 상태(판매중인지 품절인지 체크해주는 필드)
	 private int isSoldout;
		
	//상품을 판매하는 판매자가 여러명일 수 있으므로 판매자가 누구인지 아이디를 넣어줘야한다
	//판매자 아이디(admin)
	//@ManyToOne //판매자 한명이 여러개의 상품을 팔 수 있기 때문에  판매자 1 : 상품 N (판매자한테 상품은 하나) 
	//@JoinColumn(name="admin_id")
	//private Admin admin;
	 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private User seller; // 판매자 아이디
       
    //private List<카트에 담긴 상품들> cart_items = new ArrayList<>();
  	@OneToMany(mappedBy = "item")
  	private List<CartItem> cartItems = new ArrayList<>();
  		
	
    private String imgName; // 이미지 파일명
	
	
    private String imgPath; // 이미지 조회 경로
	
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 상품 등록 날짜

    @PrePersist // DB에 INSERT 되기 직전에 실행. 즉 DB에 값을 넣으면 자동으로 실행됨
    public void createDate() {
        this.createDate = LocalDate.now();

    }
	
}


/*
	Lombok
	
		@Builder : 객체를 생성할 때 매개변수의 순서나 개수에 관계없이 보기 편할 수 있도록 객체를 생성할 수 있게 도와주는 메서드
		@AllArgsContructor : 모든 필드에 생성자를 생성해줌
							 이를 사용하여 객체를 생성할 때 모든 필드를 포함하는 생성자를 쉽게 만들수 있다
			예제코드 :
			
			@AllArgsContructor
			public class Student {
				private String name; // new Student("학생명",3)
				private int grade;
			}
		
		@NoArgsconstructor : 매개변수가 없는 기본 생성자를 생성해줌
				예제코드 : 
				
				@NoArgsconstructor
				public class School {
										//new School()
				}
		
		@RequiredArgsConstructor : 이 어노테이션이 적용된 클래스는 필수로 초기화 해야하는 final필드나 @NotNull로 표시된 필드를 사용하는 생성자를 자동으로 생성해준다
				예제코드 :
			
			@RequiredArgsConstructor
			public class Student{
				private final String name;
				private final int grade;
				private String address;
			}
			=> final이 붙은 name과 grade는 생성자에 포함되지만 address는 생성자에 포함되지 않는다
				나중에 Student 객체를 다른데서 불러올 때 Student st = new Student("이름", 학년);은 필수지만
				address는 필수가 아니다(넣어도되고 안넣어도 됨)
						
*/		

