package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_seq")
	@SequenceGenerator(name="products_seq", sequenceName="products_seq", allocationSize=1)
	private int id;
	
	private String name;
	
	private String text;
	
	private String price;
	
	private int count;
	
	private int stock;
	
	private int isSoldout;
	
	//댓글 작성을 위한 Comment
	//@OneToMany(mappedBy="Products", cascade=CascadeType.ALL)
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL) //cascade=CascadeType.ALL 삭제하면 전부다 삭제하게 하는 것
	private List<Comment> comments;
	
	//상품 이미지를 위한 필드 설정
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-dd-mm")
	private LocalDate createDate;
	
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
}


/*
.html
index.html - 회원가입 로그인 로그아웃버튼, 상품리스트로 이동하기 버튼
login_form - 아이디, 패스워드 / 아이디찾기(이름 넣어서 일치하는 이름이 있으면 아이디전달,detail상세보기와 같음) 
signup_form - 회원가입 아이디 비밀번호 비밀번호확인 이름 이메일 
product_list - 상품명 상품상세보기 상품가격 (장바구니 담기)
product_detail - 상품에 대한 상세정보

ProductController - 상품리스트, 상품 상세보기,
UserController - 회원가입,로그인,로그아웃
CartController - 장바구니에 상품 담기, 상품 주문하기



product - 상품명 설명 가격 판매개수 재고 품절유무 업로드 이미지 파일명 파일경로 상품등록일
productdetail
productList
*/
