package com.kh.spring.cafe.vo;

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
@Table(name="Cafes")
@SequenceGenerator(name="cafes_sequence", sequenceName="cafes_sequence", allocationSize=1)
public class Cafe {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cafes_sequence")
	
	@Id
	@Column(name="cafeid")
	private Long cafeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="openinghours")
	private String openingHours;
}
