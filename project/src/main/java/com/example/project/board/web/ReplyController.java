package com.example.project.board.web;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.ReplyVO;

@Controller
@RequestMapping("/board")
public class ReplyController {
	
	@Resource
	private BoardService boardService;
	// 댓글 쓰기
	@RequestMapping(value = "/{boardId}/reply", method = RequestMethod.POST)
	public String replyInsert(@ModelAttribute ReplyVO replyVO, 
			@PathVariable String boardId) throws Exception {
		
		boardService.insertReplyList(replyVO);
		
		return "redirect:/board/" + boardId;
	}
	// 댓글 수정
	@RequestMapping(value = "/{boardId}/reply/{replyId}", method = RequestMethod.PATCH)
	public String replyUpdate(@ModelAttribute ReplyVO replyVO, 
			@PathVariable String boardId, @PathVariable int replyId) throws Exception {
		
		replyVO.setReplyId(replyId);
		System.out.println(replyVO.getReplyContent());
		boardService.updateReplyList(replyVO);
		
		return "redirect:/board/" + boardId;
	}
	// 댓글 삭제
	@RequestMapping(value = "/{boardId}/reply/{replyId}", method = RequestMethod.DELETE)
	public String replyDelete(@ModelAttribute ReplyVO replyVO, 
			@PathVariable String boardId, @PathVariable int replyId) throws Exception {
		
		replyVO.setReplyId(replyId);
		boardService.deleteReplyList(replyVO);
		
		return "redirect:/board/" + boardId;
	}
		
	

}
