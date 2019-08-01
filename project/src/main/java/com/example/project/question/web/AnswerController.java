package com.example.project.question.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnswerController {
	// 메인 화면
	@RequestMapping(value="/product")
	public String productInit() {
		return "product/product";
	}
	
	// 생성
	@RequestMapping(value="/product/new", method = RequestMethod.POST)
	public String productInsert() {
		return "product/product";
	}
		
	// 수정
	@RequestMapping(value="/product/new/{productId}", method = RequestMethod.PATCH)
	public String productUpdate() {
		return "product/product";
	}
		
	// 삭제
	@RequestMapping(value="/product/new/{productId}", method = RequestMethod.DELETE)
	public String productDelete() {
		return "product/product";
	}
}
