package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produc_seq")
	@SequenceGenerator(name="produc_seq", sequenceName="produc_seq", allocationSize=1)
	private int id;
	
	private String name;
	
	private String text;
	
	private String price;
	
	private int count;
	
	private int stock;
	
	private int isSoldout;
	
	//상품 이미지를 위한 필드 설정
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-dd-mm")
	private LocalDate createDate;
	
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
}
