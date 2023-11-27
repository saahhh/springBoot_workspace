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
	
	//게시판에서 게시물 전체보기 Service
	public List<Board> getAllBoards() {
		return boardMapper.getAllBoards();	
	}
	
	//게시판에서 게시물 한 개 선택했을 때 한 가지에 대한 상세보기 Service
	public Board getBoardById(int boardId) {
		return boardMapper.getBoardById(boardId);
	}
	
	//게시판에서 게시글 작성하기 Service
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}
	
	//게시판에서 게시글 수정하기 Service
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}
	
	//게시판에서 게시글 삭제하기 Service
	public void deleteBoard(int boardId) {
		boardMapper.deleteBoard(boardId);
	}
	
}
