package com.kh.springdb.model.vo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstrcutor
@AllArgsConstrcutor
@Getter
@Setter
@Entity
public class SaleItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="saleItem_seq")
	@SequenceGenerator(name="saleItem_seq", sequenceName="saleItem_seq", allocationSize=1)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="")
	private Sale sale;
//판매자가 판매할 상품에 대한 정보를 작성
//판매자
	//판매자입장 : 고객이 주문한 상품 번호
	//			고객이 주문한 상품 이름
	//			고객이 주문한 상품 가격
	//			총 수익
	
	
}
