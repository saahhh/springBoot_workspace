package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.Board;
import com.kh.springdb.service.BoardService;


@Controller
@RequestMapping("/boards")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping //@GetMapping("/boards") => "@RequestMapping("/boards") 위에서 한번에 선언해줘서 ("/boards")를 쓰지 않아도 됨 
	public String getAllBoards(Model model) {
		//게시물 전체보는 Controller
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "board-list";
	}
	
	@GetMapping("/{boardId}")// "/boards/{boardId}"로 앞에 boards가 내장(내부적으로 작동)되어 있음
	public String getBoardbyId(@PathVariable int boardId, Model model) {
		Board board = boardService.getBoardById(boardId);
		model.addAttribute("board", board);
		return "board-detail";
	}
	
	//@GetMapping을 사용해서 게시글 작성하는 html로 이동한 후 
	@GetMapping("/create") //HTTP GET요청이 /create 라는 경로로 들어올 때 호출된다
	public String displayCreateForm(Model model) { //Model이라는 객체를 매개변수로 받아서 templates(view)으로 데이터를 전달할 수 있음
		model.addAttribute("board", new Board());
		//new Board로 새로운 Board 객체를 생성해서 모델에 추가
		return "board-form"; //board-form.html 템플릿에서 해당 뷰를 보여준다
		
	}
	
	//@PostMapping을 사용해서 작성해놓은 insert HTML form을 가져온다
	@PostMapping("create")
	public String createBoard(@ModelAttribute Board board) {
		boardService.insertBoard(board);
		return "redirect:/boards"; //글이 작성된 후 돌아갈 템플릿 작성
	}
	
	@PostMapping("/update/{boardId}")
	public String UpdateForm(@PathVariable int boardId, @ModelAttribute Board board) {
		//수정한 내용을 setBoardId를 통해 저장하고 난 후 BoardService로 불러옴
		//URL에서 가져온 boardId값을 Board 객체에 저장
		board.setBoardId(boardId);
		boardService.updateBoard(board);
		
		//수정이 완료된 후 게시글 목록 페이지로 돌아가기
		return "redirect:/boards";
	}
	
	@GetMapping("/update/{boardId}")
	public String displayupdateForm(@PathVariable int boardId, Model model) {
		Board board = boardService.getBoardById(boardId);
		model.addAttribute(board);
		return "board-form";
	}
	
	/*
	 Model model
	 	컨트롤러에서 뷰로 데이터를 전달할 때 사용하는 인터페이스
	 	컨트롤러에 있는 메서드에서 매개변수로 Model를 선언하면 Get에 추가한 데이터는 자동으로 뷰에 전달됨
	 	select 에서 DB에서 담겨온 데이터는 자동으로 모델에 담겨져 View(html)파일로 전달되는 것이다.
	 @ModleAttribute 클래스이름 클래스를대신할변수명
	 	폼 데이터나 URL 경로에서 전달된 데이터를 객체에 넣어줄 때 사용한다
	 	클라이언트에서 전송한 데이터를 객체로 값을 넣어주고 컨트롤러에서 사용할 수 있도록 해주는 것
	 	전달된 데이터는 mapper를 통해 db에 저장된다.	 
	*/
	
	
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable int boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/boards";
		
	}
	
	
}
