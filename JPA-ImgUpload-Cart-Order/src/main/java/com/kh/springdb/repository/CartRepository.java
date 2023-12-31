package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;

public interface CartRepository  extends JpaRepository<Cart, Integer> {
	
	//사용자 Id를 바탕으로해서 id주인의 카트를 조회하기 위해 사용하는 메서드
	Cart findByUserId(int id);
	//주어진 Id의 CartId를 바탕으로 카트 내용 조회
	Cart findCartById(int id);
	//카트에서 Cart를 중점으로 UserId를 검색해서 조회하는데 사용
	Cart findCartByUserId(int userId);
	

}
