package com.kh.springdb.vo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ProductItem") //테이블을 생성해주는 어노테이션
public class Product {
	@Id
	@Column(name="product_id")
	private Long product_id;
	
	@Column(nullable = false, length = 50)
	private String product_name;
	
	@Column(nullable = false, length = 50)
	private String category;
	
	@Column(name="price")
	private int price;
	
}

/*
	@Table : 테이블 이름을 지정해주는 어노테이션
	@Id : 해당 필드가 엔터티의 primaryKey임을 나타낸다
	@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있다
		nullable : 해당 컬럼이 null값을 허용하는지 여부를 나타낸다. (JPA안에 들어가있는 공식)
		length : 문자열 컬럼의 최대 길이를 지정하는 것
		String으로 시작되는 필드값의 경우 String으로 지정된 이름으로 명시되기 때문에 따로 name을 지정해주지 않아도 되지만 String 이외의 값은 name을 설정해주어 column명을 지정해주는 것이 원칙이다
				
*/
 