package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_Seq")
	@SequenceGenerator(name="customer_Seq", sequenceName="customer_Seq", allocationSize=1)
	private Long CustomerId;
	private Long CustomerPw;
	private String CustomerEmail;
}
