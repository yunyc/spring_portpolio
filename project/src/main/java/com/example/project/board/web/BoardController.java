package com.example.project.board.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.board.service.VO.BoardReplyVO;
import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.board.service.VO.PagingVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String boardInit(@ModelAttribute BoardVO boardVO, @ModelAttribute PagingVO pagingVO, Model model) throws Exception {
		
		pagingVO = boardService.countBoardList();
		pagingVO.PageInit();
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardPageVO", pagingVO.getPageList());
		
		return "board/board";
	}
	
	@RequestMapping(value = "/newboard")
	public String boardInsertInit(@ModelAttribute BoardVO boardVO, 
			@RequestParam String method, Model model) throws Exception {
		
		model.addAttribute("BoardVO", boardVO);
		model.addAttribute("method", method);
		
		return "board/boardInsert";
	}
	
	
	@RequestMapping(value = "/newboard", method = RequestMethod.POST)
	public String boardInsertSubmit(@ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.insertBoardList(boardVO);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/newboard", method = RequestMethod.PATCH)
	public String boardUpdateSubmit(@ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.updateBoardList(boardVO);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/{boardId}", method = RequestMethod.DELETE)
	public String boardDelete(@PathVariable int boardId) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);
		
		BoardReplyVO replyVO = new BoardReplyVO();
		replyVO.setBoardId(boardId);
		
		boardService.deleteReplyList(replyVO);
		boardService.deleteBoardList(boardVO);
		
		return "redirect:/board";
	}
	
	
	@RequestMapping(value = "/{boardId}", method = RequestMethod.GET)
	public String boardDetail(@PathVariable int boardId, Model model) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);
		
		BoardReplyVO replyVO  = new BoardReplyVO();
		replyVO.setBoardId(boardId);
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		List<BoardReplyVO> replyList = boardService.selectReplyList(replyVO);
		
		model.addAttribute("boardVO", boardList.get(0));
		model.addAttribute("replyList", replyList);
		model.addAttribute("replyVO", replyVO);
		
		return "board/boardDetail";
	}
	

	
	@RequestMapping(value = "/{boardId}", method = RequestMethod.POST)
	public String boardDetailRegister() throws Exception {
		
		
		
		return null;
	}
	          

}
