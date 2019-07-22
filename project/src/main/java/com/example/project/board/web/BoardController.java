package com.example.project.board.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.board.service.VO.BoardPageVO;
import com.example.project.board.service.VO.BoardReplyVO;
import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;

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
	
	@RequestMapping("/board/boardDetail.do")
	public String boardDetailInit(@ModelAttribute BoardVO boardVO, 
			@ModelAttribute BoardReplyVO replyVO, Model model) throws Exception {
	
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		List<BoardReplyVO> replyList = boardService.selectReplyList(replyVO);
		
		model.addAttribute("boardList", boardList.get(0));
		model.addAttribute("replyList", replyList);
		model.addAttribute("replyVO", replyVO);
		
		return "board/boardDetail";
	}
	
	@RequestMapping("/board/boardDetail/replyRegister.do")
	public String boardDetailRegister(@ModelAttribute BoardReplyVO replyVO, @RequestParam String mode,
			Model model) throws Exception {
		
		model.addAttribute("replyVO", replyVO);
		model.addAttribute("mode", mode);
		
		if (mode == "delete") {
			boardService.deleteReplyList(replyVO);
			return "redirect:/board.do";
		}
		
		return "board/replyRegister";
	}
	              
	@RequestMapping("/board/boardDetail/replyRegister/submit.do")
	public String boardDetailRegisterSubmit(@ModelAttribute BoardReplyVO replyVO, @RequestParam String mode, 
			Model model) throws Exception {
		
		if (mode == "insert") {
			boardService.insertReplyList(replyVO);
		} else if (mode == "update") {
			boardService.updateReplyList(replyVO);
		}
				
		return "redirect:/board.do";
	}

}
