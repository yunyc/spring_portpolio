package com.example.project.admin;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

/**
 * @Class Name : QuestController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author yunyc
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private QuestService questService;
	
	@Resource
	private BoardService boardService;
	
	/**
	 * 사용자 정보 조회
	 * @param map - 사용자 정보가 담긴 HashMap
	 * @param model
	 * @return 사용자 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/user")
	public String adminUserInit(HashMap<String, Object> map, Model model) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(map);
		
		model.addAttribute("userList", userList);
		
		return "admin/admin";
	}
	
	/**
	 * 상품 정보 조회
	 * @param productVO - 검색 옵션 정보가 담긴 ProductVO
	 * @param model
	 * @return 상품 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/product")
	public String adminProductInit(ProductVO productVO, Model model) throws Exception {
		
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		model.addAttribute("productList", productList);
		
		return "admin/admin";
	}
	
	/**
	 * 질문 정보 조회
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param model
	 * @return 질문 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/quest")
	public String adminQuestInit(QuestVO questVO, Model model) throws Exception {
		
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questList", questList);
		
		return "admin/admin";
	}
	
	/**
	 * 문의사항 조회
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @param model
	 * @return 문의사항 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/board")
	public String adminBoardInit(BoardVO boardVO, Model model) throws Exception {
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		model.addAttribute("boardList", boardList);
		
		return "admin/admin";
	}
}
