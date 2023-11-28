package com.kh.springdb.vo;


import lombok.Getter;
import lombok.Setter;

public class Product {
	@Getter
	@Setter
	private int product_id;
	@Getter
	@Setter
	private String product_name;
	@Getter
	@Setter
	private String category;
	@Getter
	@Setter
	private int price;
	@Getter
	@Setter
	private int stock_quantity;
}
