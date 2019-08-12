package com.example.project.main.web;

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

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Controller
public class MainController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private QuestService questService;
	
	@Resource
	private ProductService productService;
	
	// 메인 화면 초기화
	@RequestMapping("/main")
	public String mainInit(QuestVO questVO, ProductVO productVO, Model model) throws Exception {
		
		List<QuestVO> questList = questService.selectQuestList(questVO);	
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		model.addAttribute("questList", questList);
		model.addAttribute("productList", productList);
		return "main/main";
	}
	
}
