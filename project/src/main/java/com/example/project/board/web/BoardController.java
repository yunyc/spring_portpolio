package com.example.project.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.board.service.BoardPageVO;
import com.example.project.board.service.BoardService;
import com.example.project.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board.do")
	public String boardInit(@ModelAttribute BoardVO boardVO, Model model) throws Exception {
		
		BoardVO defaultBoardVO = new BoardVO();
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		defaultBoardVO.setCurrentPage(0);
		List<BoardVO> defaultBoardList = boardService.selectBoardList(defaultBoardVO);
		
		BoardPageVO boardPageVO = new BoardPageVO(defaultBoardList.size());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardPageVO", boardPageVO.getPageList());
		
		
		return "board/board";
	}
	
	@RequestMapping("/common/boardInsert.do")
	public String boardInsert(Model model) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		model.addAttribute("BoardVO", boardVO);
		
		return "board/boardInsert";
	}
	
	@RequestMapping("/common/boardInsert/submit.do")
	public String boardSubmit(@ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.insertBoardList(boardVO);
		
		return "redirect:/board.do";
	}

}
