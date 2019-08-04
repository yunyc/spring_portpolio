package com.example.project.admin.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.board.service.BoardService;
import com.example.project.product.service.ProductService;
import com.example.project.question.service.QuestService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private BoardService BoardService;
	
	@Resource
	private QuestService QuestService;
	
	@Resource
	private ProductService productService;
	
	// 사용자 조회 페이지
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userSelect(UserVO userVO, Model model) {
		
		//userService.selectUserList(map);
		model.addAttribute("userVO", userVO);
		return null;
	}
	// 사용자 정보 수정
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PATCH)
	public String userUpdate(UserVO userVO, Model model) {
		
		//userService.update
		return null;
	}
	// 글 목록 조회 페이지
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardSelect() {
		return null;
	}
	// 글 삭제
	@RequestMapping(value = "/board/{boardId}", method = RequestMethod.DELETE)
	public String boardDelete() {
		return null;
	}
	// 답변 목록 조회 페이지
	@RequestMapping(value = "/quest", method = RequestMethod.GET)
	public String questSelect() {
		return null;
	}
	// 답변 삭제 
	@RequestMapping(value = "/quest/{questId}", method = RequestMethod.DELETE)
	public String questDelete() {
		return null;
	}
	// 상품 목록 조회 페이지
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productSelect() {
		return null;
	}
	// 상품 삭제
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public String productDelete() {
		return null;
	}
		

	
	

}
