package com.example.project.user.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.product.service.ProductService;
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
public class MyPageController {
	
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
	 * @param req - 요청 정보 HttpServletRequest
	 * @param model
	 * @return 사용자 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/mypage/user")
	public String mypageUserInit(HttpServletRequest req,
			HashMap<String, Object> map, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		map.put("userId", session.getAttribute("userId"));
		
		List<UserVO> userList = userService.selectUserList(map);
		
		model.addAttribute("userList", userList);
				
		return "user/myPage";
	}
	
	/**
	 * 주문 정보 조회
	 * @param req 요청 정보 HttpServletRequest
	 * @param model
	 * @return 주문 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/mypage/order")
	public String mypageOrderInit(HttpServletRequest req, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		
		List<HashMap<String, Object>> orderList = productService.selectOrder((String)session.getAttribute("userId"));
		
		model.addAttribute("orderList", orderList);
				
		return "user/myPage";
	}
	
	/**
	 * 질문 정보 조회
	 * @param req - 요청 정보 HttpServletRequest
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param model
	 * @return 질문 정보 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/mypage/quest")
	public String mypageQuestInit(HttpServletRequest req,
			QuestVO questVO, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		questVO.setUserId((String)session.getAttribute("userId"));
		
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questList", questList);
				
		return "user/myPage";
	}
	
	/**
	 * 문의사항 조회
	 * @param req - 요청 정보 HttpServletRequest
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @param model
	 * @return 문의사항 조회 결과
	 * @exception Exception
	 */
	@GetMapping("/mypage/board")
	public String mypageBoardInit(HttpServletRequest req,
			BoardVO boardVO, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		boardVO.setUserId((String)session.getAttribute("userId"));
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		model.addAttribute("boardList", boardList);
				
		return "user/myPage";
	}

}
