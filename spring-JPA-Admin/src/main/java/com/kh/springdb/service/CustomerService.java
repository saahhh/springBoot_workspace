package com.kh.springdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.CustomerRepository;
import com.kh.springdb.vo.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	
	
	public void validateDuplicateCustomer(Customer customer) {
		Optional<Customer> findCustomer = customerRepository.findById(customer.getCustomerId());
	}

	
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	
}
