package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="u_seq")
	@SequenceGenerator(name="u_seq", sequenceName="u_seq", allocationSize=1)
	private Long id;
	
	//isRole 가입할 때마다 이 사람이 판매자인지 소비자인지 체크해서 가입하기
	//@Enumerated(EnumType.STRING) //상수라는 어노테이션 입력해줘야함
	//private UserRole isRole;
	private String isRole;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	@Column(unique=true)
	private String email;
	
	
	//추천인을 넣고싶다면 추천자를 생성해서 넣어도된다
	
}
