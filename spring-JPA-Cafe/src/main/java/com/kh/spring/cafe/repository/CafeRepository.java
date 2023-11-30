package com.kh.spring.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.spring.cafe.vo.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
	
	//특정 문자열을 포함한 엔터티를 검색하는데 사용하는 메서드
	List<Cafe> findByNameContaining(String keyword);
	
	/*
	 findByNameContaining : JPA안에 내장되어 있는 메서드
	 */
	
	
	
	/*
	@Query("SELECT c FROM Cafe c WHERE c.name LIKE %:keyword%")
	//1.만약에 내가 보여줄 것이 많다 => List로 담아서 한번에 보여주자
	List<Cafe> findCafeName(@Param("keyword") String keyword);
	
	//2.보여줄 것이 하나 => Cafe 객체 하나만 호출 할 것
	*/
}
