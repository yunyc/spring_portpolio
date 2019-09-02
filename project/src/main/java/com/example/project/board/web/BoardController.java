package com.example.project.board.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.board.service.VO.ReplyVO;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.paging.PagingVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;


/**
 * @Class Name : BoardController.java
 * @Description : BoardController Class
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

@Controller
@RequestMapping("/board")
public class BoardController {
	
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
	 * 게시글 목록을 조회
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @param pagingVO - 페이징 정보가 담긴 PagingVO
	 * @param model
	 * @return "board"
	 * @exception Exception
	 */
	@GetMapping("")
	public String boardInit(BoardVO boardVO, @ModelAttribute PagingVO pagingVO,
			Model model) throws Exception {
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		pagingVO.setIndexSize(10);
		pagingVO.setBoardCount(boardList.size());
		pagingVO.setPageSize(10);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingVO", pagingVO);
		
		return "board/board";
	}
	
	/**
	 * 게시글 상세 정보 조회
	 * @param boardId - 게시글 식별 번호
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @param replyVO - 페이징 정보가 담긴 ReplyVO
	 * @param model
	 * @return "boardDetail"
	 * @exception Exception
	 */
	@GetMapping("/{boardId}")
	public String boardDetail(@PathVariable int boardId, Model model,
			BoardVO boardVO, ReplyVO replyVO) throws Exception {

		boardVO.setBoardId(boardId);
		replyVO.setBoardId(boardId);
		
		try {
			boardVO = boardService.selectBoardList(boardVO).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<ReplyVO> replyList = boardService.selectReplyList(replyVO);
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("replyList", replyList);
		model.addAttribute("replyVO", replyVO);
		
		return "board/boardDetail";
	}
	
	/**
	 * 게시글 작성 페이지 이동
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @param model
	 * @return "boardInsert"
	 * @exception Exception
	 */
	@GetMapping("/post")
	public String boardInsertInit(BoardVO boardVO, Model model) throws Exception {
		
		model.addAttribute("BoardVO", boardVO);
		model.addAttribute("method", "post");
		
		return "board/boardInsert";
	}
	
	/**
	 * 게시글 작성
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @return "redirect:/board"
	 * @exception Exception
	 */
	@PostMapping("/post")
	public String boardInsertSubmit(@ModelAttribute @Valid BoardVO boardVO) throws Exception {
		
		boardService.insertBoardList(boardVO);
		
		return "redirect:/board";
	}
	
	/**
	 * 게시글 수정 페이지 이동
	 * @param boardId - 게시글 식별 번호
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @param model
	 * @return "boardInsert"
	 * @exception Exception
	 */
	@GetMapping("/post/{boardId}")
	public String boardUpdateInit(@PathVariable int boardId,
			BoardVO boardVO, Model model) throws Exception {
		
		boardVO.setBoardId(boardId);
		
		try {
			boardVO = boardService.selectBoardList(boardVO).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("BoardVO", boardVO);
		model.addAttribute("method", "patch");
			
		return "board/boardInsert";
	}
	
	/**
	 * 게시글 수정
	 * @param boardId - 게시글 식별 번호
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @return "redirect:/board/" + boardId
	 * @exception Exception
	 */
	@PatchMapping("/post/{boardId}")
	public String boardUpdateSubmit(@ModelAttribute @Valid BoardVO boardVO,
			@PathVariable int boardId) throws Exception {
		
		boardService.updateBoardList(boardVO);
		
		return "redirect:/board/" + boardId;
	}
	
	/**
	 * 게시글 삭제
	 * @param boardId - 게시글 식별 번호
	 * @param boardVO - 질문 정보가 담긴 BoardVO
	 * @return "redirect:/board/" + boardId
	 * @exception Exception
	 */
	@DeleteMapping("/post/{boardId}")
	public String boardDelete(@PathVariable int boardId, BoardVO boardVO,
			ReplyVO replyVO) throws Exception {

		boardVO.setBoardId(boardId);
		replyVO.setBoardId(boardId);

		boardService.deleteBoardList(boardVO);
		
		return "redirect:/board" + boardId;
	}

}
