package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.STMember;

public interface StmemberRepository extends JpaRepository<STMember, Long>{
	
}
