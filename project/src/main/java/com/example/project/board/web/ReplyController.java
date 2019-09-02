package com.example.project.board.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.ReplyVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;

/**
 * @Class Name : ReplyController.java
 * @Description : ReplyController Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

@RestController
@RequestMapping("/board")
public class ReplyController {
	
	/** BoardService 인터페이스 */
	@Resource
	private BoardService boardService;
	
	@Resource
	private QuestService questService;
	
	@Resource
	private ProductService productService;
	
	@ModelAttribute("bestQuestList")
	public List<QuestVO> sideQuestInit(QuestVO questVO) throws Exception {
		
		questVO.setQuestGood(1);
		return questService.selectQuestList(questVO);
		
	}
	
	@ModelAttribute("bestProductList")
	public List<ProductVO> sideProductInit(ProductVO productVO) throws Exception {
		
		productVO.setProductGood(1);
		return productService.selectProductList(productVO);
	}

	/**
	 * 댓글 달기
	 * @param replyMap - 댓글 정보가 담긴 HashMap
	 * @return "replyMap"
	 * @exception Exception
	 */
	@ResponseBody
	@PostMapping("/{boardId}/reply/*")
	public HashMap<String, Object> replyInsert(@RequestBody HashMap<String, Object> replyMap, 
			@PathVariable String boardId) throws Exception {
		
		boardService.insertReplyList(replyMap);
		
		return replyMap;
	}
	
	/**
	 * 댓글 수정
	 * @param replyMap - 댓글 정보가 담긴 HashMap
	 * @param boardId - 게시글 식별 번호
	 * @param replyId - 댓글 식별 번호
	 * @return "replyMap"
	 * @exception Exception
	 */
	@PatchMapping("/{boardId}/reply/{replyId}")
	public HashMap<String, Object> replyUpdate(@RequestBody HashMap<String, Object> replyMap, 
			@PathVariable String boardId, @PathVariable int replyId) throws Exception {
		
		boardService.updateReplyList(replyMap);
		
		return replyMap;
	}
	
	/**
	 * 댓글 삭제
	 * @param replyVO - 댓글 정보가 담긴 ReplyVO
	 * @param boardId - 게시글 식별 번호
	 * @param replyId - 댓글 식별 번호
	 * @return "replyMap"
	 * @exception Exception
	 */
	@DeleteMapping("/{boardId}/reply/{replyId}")
	public String replyDelete(@RequestBody ReplyVO replyVO, 
			@PathVariable String boardId, @PathVariable int replyId) throws Exception {
		
		replyVO.setReplyId(replyId);
		
		boardService.deleteReplyList(replyVO);
		
		return "redirect:/board/" + boardId;
	}
		
	

}
