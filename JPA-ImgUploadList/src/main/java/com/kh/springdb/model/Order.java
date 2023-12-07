package com.kh.springdb.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
//@Entity
@Entity(name = "customer_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="orders_seq")
	@SequenceGenerator(name="orders_seq", sequenceName="orders_seq", allocationSize=1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	private LocalDate orderDate;
	
	@PrePersist
	public void orderDate() {
		this.orderDate = LocalDate.now();
	}
}
