package com.kh.springdb.vo;

//import org.springframework.data.annotation.Id; //Nosql
//import jakarta.persistence.Id; //관계형sql

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Products") //테이블명과 클래스명을 맞춰도 되고 아니여도 됨
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	/*
	//Oracle -> @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
	
	@SequenceGenerator(name="product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)
	
	//MySQL 에서 사용하는 방식 -> @GeneratedValue(strategy = GenerationType.IDENTITY) //일반적으로 시퀀스와 같은 것
	*/
	
	//@Column(name="product_id")
	private Long product_id;
	
	//@Column(nullable = false, length = 50)
	private String product_name;
	
	//@Column(nullable = false, length = 50)
	private String category;
	
	//@Column(name="price")
	private Double price;
	
	private Integer stock_quantity;
	
}	//DB에 있는 순서와 다르면 오류남

/*
	@Table : 테이블 이름을 지정해주는 어노테이션
	@Id : 해당 필드가 엔터티의 primaryKey임을 나타낸다
	@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있다
		nullable : 해당 컬럼이 null값을 허용하는지 여부를 나타낸다. (JPA안에 들어가있는 공식)
		length : 문자열 컬럼의 최대 길이를 지정하는 것
		String으로 시작되는 필드값의 경우 String으로 지정된 이름으로 명시되기 때문에 따로 name을 지정해주지 않아도 되지만 
		String 이외의 값은 name을 설정해주어 column명을 지정해주는 것이 원칙이다
	
	
				
	@GeneratedValue : JPA에서 엔터티의 기본 키 값을 자동으로 생성하는 방법을 지정하는데 사용하는 어노테이션
		시퀀스를 사용해서 기본키 값을 생성할 수 있도록 지원해준다
		시퀀스는 데이터베이스에서 중복되는 값이 아닌 각 레코드가 고유한 숫자번호를 가질 수 있도록 자동으로 값을 생성해준다
		
		@SequenceGenerator : GeneratedValue와 연결할 이름을 설정해주고 시퀀스의 이름과 크기를 지정할 수 있다
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	
	@SequenceGenerator(name="product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)
		데이터베이스 자체에서 자동으로 값이 증가할 수 있도록 자동생성이 들어있는 경우
		아래 어노테이션 방식을 사용한다
		새로운 레코드가 삽입될 때 마다 데이터베이스가 자동으로 기본키의 값을 증가시킨다
		
	@GeneratedValue(strategy = GenerationType.IDENTITY) //일반적으로 시퀀스와 같은 것
				
*/
 

/*
	@Controller 와 @RestController
	@Controller : 어노테이션이 부착된 전통적인 SpringMVC 패턴을 적용한 것이다
				  View를 생성하고 반환하는 역할을 하기도 한다
				  주로 @RequestMapping과 함께 사용하고 HTTP요청을 처리하고 그 결과를 View로 보낸다
				  데이터를 반환할 때는 Model객체를 통해 View에 데이터를 전달한다
	@RestController : 조금 더 RESTful 웹 서비스를 제공하는데 특화된 어노테이션
					  @Controller에 @ResponseBody를 함께 사용한 것과 유사하게 동작한다
					  이런 기능들을 편리하게 사용할 수 있도록 조금 더 특수하게 만들어진 어노테이션
	주로 @Controller는 View(html 파일)을 반환하는데 사용되고
	    @RestController는 @Controller에 @ResponseBody를 추가로 사용하는 것을 대체할 수 있어 코드가 조금 더 간결해진다 
	
	@ResponseBody : 메서드가 return해서 반환해야하는 값을 HTTP 응답에서 html로 전달하는 것이 아닌 java코드에서 직접 본문으로 전달해서 사용할 수 있는 어노테이션
					  
*/
