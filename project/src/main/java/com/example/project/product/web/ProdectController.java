package com.example.project.product.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.paging.PagingVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;

@Controller
@RequestMapping(value = "/product")
public class ProdectController {
	
	@Resource
	private ProductService productService;
	
	// 상품 페이지 이동
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String productInit() {
		return null;
		
	}
	// 상품 페이지 게시글 페이징 처리
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String productBoardInit() {
		
		return null;
			
	}
	// 상품 상세 페이지 이동
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String productDetail(@PathVariable int productId, 
			ProductVO productVO, Model model) throws Exception {
		
		productVO.setProductId(productId);
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		model.addAttribute("productVO", productList.get(0));
		
		return null;
		
	}
	// 상품 등록 페이지 이동
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String productInsertInit() {
		return null;
		
	}
	// 상품 등록 정보 전송
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String productInsert(@ModelAttribute ProductVO productVO) throws Exception {
		
		productService.insertProduct(productVO);
		return null;
		
	}
	// 상품 등록 정보 수정
	@RequestMapping(value = "/regist/{productId}", method = RequestMethod.PATCH)
	public String productUpdate(@PathVariable int productId, 
			@ModelAttribute ProductVO productVO) throws Exception {
		
		productVO.setProductId(productId);
		productService.updateProduct(productVO);
		return null;
		
	}
	
	// 상품 등록 정보 삭제
	@RequestMapping(value = "/regist/{productId}", method = RequestMethod.DELETE)
	public String productDelete(@ModelAttribute ProductVO productVO, 
			@PathVariable int productId) throws Exception {
		
		productVO.setProductId(productId);
		productService.deleteProduct(productVO);
		return null;
			
		}

}
