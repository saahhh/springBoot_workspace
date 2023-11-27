package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.Board;
import com.kh.springdb.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("boardList")
	public String displayBoardList(Model model) {
		
		model.addAttribute("boards", boardService.getAllBoards());
		return "boardList";
	}
	
	@RequestMapping("/board-update/{id}")
	public String updateBoard(@PathVariable int id, @ModelAttribute("board") @Validated Board board, BindingResult result) {
		board.setBoard_id(id);
		boardService.updateBoard(board);
		return "redirect:/boardList";
	}
	
	@DeleteMapping("/board-delete/{id}")
	public String deleteBoard(@PathVariable int id, @ModelAttribute("board") @Validated Board board, BindingResult result) {
		boardService.deleteBoard(id);
		return "redirect:/boardList";
	}
}
