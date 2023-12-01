package com.kh.spring.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.spring.cafe.vo.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
	
	//카페가 존재하는지 존재여부(boolean)
	boolean existsByName(String name);
	
	//count를 이용해서 지역의 갯수가 몇 개인지 찾아보는 메서드
	int countByLocation(String location);
		
	//특정 문자열을 포함한 엔터티를 검색하는데 사용하는 메서드
	List<Cafe> findByNameContaining(String keyword);
	
	/*
	 findByNameContaining : JPA안에 내장되어 있는 메서드
	 */

	
	/*
	
		Query Creation : Spring Data JPA에서 제공하는 기능
		메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능
		메서드 이름으로 데이터베이스 쿼리를 생성
		
		JPA 규칙을 지정해서 이 규칙만 지켜주면 
		내가 알아서 쿼리를 만들어줄게~
		
		findby + 내가 적고(찾고)싶은 엔터티 변수이름 :
		 예를들어 Cafe라는 Class에 작성해놓은 
		 	private String name;
			private String location;
			private String openingHours; 에서
			

			지역을 검색하고 싶다면
				findByLocation(String location)
				=>SELECT * FROM Cafe WHERE location = ?
				Containing => 해당하는 변수명이 특정 변수에 대한 검색을 Like로 진행할 수 있게 도와준다
				
			운영시간을 검색하고 싶다면
				findbyOpeningHours(String openingHours)
				=>SELECT * FROM Cafe WHERE openingHours = ? 의 쿼리가 자동으로 생성되는 것
				
			총 갯수를 계산해주는 메서드를 만들고 싶다면
				countBy 클래스에 적어준 변수명
					countByLocation(String location)
					=>SELECT COUNT(*) FROM Cafe WHERE location = ?
					
			존재여부를 확인해주는 메서드를 만들고 싶다면
				existsBy 클래스에 적어준 변수명
					countByLocation(String location)
					SELECT CASE WHEN COUNT(*) > 0 THEN true
												  ELSE false
							END FROM Cafe WHERE location = ?
			
			만약에 삭제하고 싶다면 
				deleteBy 클래스에 적어준 변수명
					deleteByLocation(String location)
					DELETE FROM Cafe WHERE location = ?
					
				
			(추가)
			Query -> AND OR IS EQUALS BETWEEN AFTER BEFORE LIKE ORDERBY IN FALSE TRUE IGNORE
			
			1. JPA에서 SQL AND구문을 써야할 때
			 	findBy변수명AND다른변수명 (DB컬럼명과 변수명은 맞춰주는게 좋음)
			 	
			2. JPA에서 OR 구문을 써야할 때
				findBy변수명OR다른변수명
				
			3. JPA에서 SQL IS 또는 Equals 구문을 써야할 때
				findBy변수명IS
				findBy변수명Equals
			4. JPA에서 SQL BETWEEN AFTER BEFORE LIKE 구문을 써야할 때
				findBy변수명BETWEEN
				findBy변수명AFTER
				findBy변수명BEFORE
				findBy변수명LIKE
			5. JPA에서 SQL ORDERBY 구문을 써야할 떄
				findBy변수명OrderBy정렬하고자하는기준변수명Desc
					(* Desc : 내림차순 / Asc : 오름차순)
				findBy변수명OrderBy정렬하고자하는기준변수명Asc
			6. JPA에서 SQL IN 구문을 써야할 때
				findBy변수명In(List<예약어> 변수명)
			
			7. JPA에서 SQL TRUE FALSE 구문을 써야할 때
				findBy변수명True()
				findBy변수명False()
						SQL : WHERE 테이블명의단축어.변수명(변수명=테이블명) = true
						SQL : WHERE 테이블명의단축어.변수명 = false
			8. JPA에서 SLQ IGNORECASE 구문을 써야할 때
				findBy변수명IgnoreCase
	*/
	
	
	
	/*
	@Query("SELECT c FROM Cafe c WHERE c.name LIKE %:keyword%")
	//1.만약에 내가 보여줄 것이 많다 => List로 담아서 한번에 보여주자
	List<Cafe> findCafeName(@Param("keyword") String keyword);
	
	//2.보여줄 것이 하나 => Cafe 객체 하나만 호출 할 것
	*/
}
