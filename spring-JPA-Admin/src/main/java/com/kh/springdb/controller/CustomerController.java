package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.service.CustomerService;
import com.kh.springdb.vo.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/new")
	public String joinCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "joinForm";
	}
	
	@GetMapping("/save")
	public String addCustomer(@ModelAttribute Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customers";
	}
	
}
