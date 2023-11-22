package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.ProductCommentMapper;
import com.kh.springdb.model.ProductComment;

@Service
public class ProductCommentService {
	
	@Autowired
	private ProductCommentMapper productCommentMapper;
	
	public List<ProductComment> getAllProductComments(){
		return productCommentMapper.getAllProductComments();
	}
}
