package com.example.project.board.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.ReplyVO;

@RestController
@RequestMapping("/board")
public class ReplyController {
	
	@Resource
	private BoardService boardService;
	// 댓글 쓰기
	@PostMapping("/{boardId}/reply/*")
	public HashMap<String, Object> replyInsert(@RequestBody HashMap<String, Object> map, 
			@PathVariable String boardId) throws Exception {
		
		boardService.insertReplyList(map);
		
		return map;
	}
	// 댓글 수정
	@PatchMapping("/{boardId}/reply/{replyId}")
	public HashMap<String, Object> replyUpdate(@RequestBody HashMap<String, Object> map, 
			@PathVariable String boardId, @PathVariable int replyId) throws Exception {
		
		
		boardService.updateReplyList(map);
		
		return map;
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
