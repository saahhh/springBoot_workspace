package com.kh.spring.cafe.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="Cafe")
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cafe_sequence")
	@SequenceGenerator(name="cafe_sequence", sequenceName="cafe_sequence", allocationSize=1)
	@Column(name="cafe_id")
	private Long cafeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="opening_hours")
	private String openingHours;

}
