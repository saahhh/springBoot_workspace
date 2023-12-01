package com.kh.spring.shop.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Payment {
	//데이터베이스에 주문정보를 저장하기 위한 클래스
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patMentId_Seq")
	@SequenceGenerator(name="patMentId_Seq", sequenceName="patMentId_Seq", allocationSize=1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id") //name에 대한 컬럼을 조인하겠다
	private Order order;
	private String paymentStatus;
	
}



/*
	@JoinColumn(name="조인하고자하는 컬럼명") => 외래키(FOREIGN KEY)
		데이터베이스의 테이블로 존재하는 객체를 작성
		
	@ManyToOne
		다대일(N : 1) 관계를 설정하는 어노테이션
		주문이 하나의 제품에 속하는 경우 product_id 값이 중복으로 들어갈 수 있음을 나타내기 위해 N:1이라는 설정을 해주는 것이다
		
*/
 