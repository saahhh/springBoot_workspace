package com.kh.springdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Comment;
import com.kh.springdb.model.Product;
import com.kh.springdb.repository.CommentRepository;
import com.kh.springdb.repository.ProductRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	//댓글 추가 메서드 작성
	public Comment addComment(Integer productId, String content) {
		Product product = productRepository.findById(productId).orElse(null);
		//만약에 상품이 존재하지 않을 경우 댓글 또한 존재하지 않으므로 댓글이 존재할 수 없음을 예외처리함
		if(product == null) {
			throw new RuntimeException("찾는 상품은 존재하지 않습니다.");
		}
		//댓글을 생성하기 위한 생성자
		Comment comment = new Comment();
		comment.setProduct(product);
		comment.setContent(content);
				
		return commentRepository.save(comment);
		
	}
	
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}


	public Optional<Comment> getCommentById(Long id) {
		return commentRepository.findById(id);
	}
	
	public void save(Comment comment) {
		commentRepository.save(comment);
	}

	
//	public void updateComment(Long id, String content) {
//		commentRepository.updateComment(id, content);
//	}
}
