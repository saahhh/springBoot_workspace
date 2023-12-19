package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.Comment;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {

	Optional<Comment> getCommentById(Long id);
	
		
}
