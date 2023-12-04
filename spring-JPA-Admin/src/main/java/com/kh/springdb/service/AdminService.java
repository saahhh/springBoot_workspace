package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.CustomerRepository;

@Service
public class AdminService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
}
	
