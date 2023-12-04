package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findById(String customerId);

	List<Customer> getAllCustomer();
}
