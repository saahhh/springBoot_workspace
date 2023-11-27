package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.BoardMapper;
import com.kh.springdb.model.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<Board> getAllBoards(){
		return boardMapper.getAllBoards();
	}
	
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}
	
	public void deleteBoard(int board_id) {
		boardMapper.deleteBoard(board_id);
	}
}
