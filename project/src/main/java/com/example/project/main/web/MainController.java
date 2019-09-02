package com.example.project.main.web;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

/**
 * @Class Name : MainController.java
 * @Description : MainController Class
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
public class MainController {
	
	@Resource
	private QuestService questService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private BoardService boardService;
	
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
	 * 메인 화면 초기화
	 * @param questVO - 사용자 정보가 담긴 QuestVO
	 * @param productVO - 상품 정보가 담긴 ProductVO
	 * @param boardVO - 문의사항 정보가 담긴 boardVO
	 * @param model
	 * @return "main"
	 * @exception Exception
	 */
	@RequestMapping("/main")
	public String mainInit(QuestVO questVO, ProductVO productVO,
			BoardVO boardVO, Model model) throws Exception {
		
		List<QuestVO> questList = questService.selectQuestList(questVO);	
		List<ProductVO> productList = productService.selectProductList(productVO);
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		model.addAttribute("questList", questList);
		model.addAttribute("productList", productList);
		model.addAttribute("boardList", boardList);
		return "main/main";
	}
	
	
}
