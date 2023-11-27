package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.User;

@Mapper
public interface UserMapper {
	//모든 유저 조회
	List<User> getAllUsers();
	
	//유저 한 명 조회
	User getUserById(int mno);

	//회원가입
	void insertUser(User user);
	
	User loginUser(String memail);
	
	//유저 정보 수정 메서드 (update나 insert는 void를 쓴다)
	void updateUser(User user);
	
	//delete도 void
	void deleteUser(int mno);
	
	
}
