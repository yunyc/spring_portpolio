package com.example.project.product.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.project.paging.PagingVO;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	// 상품 목록 페이지 이동
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String productInit(@ModelAttribute ProductVO productVO, Model model,
			@ModelAttribute PagingVO pagingVO) throws Exception {
		List<ProductVO> productList = null;
		
		if (productVO.getProductGood() != 0) {
		    productList = productService.selectProductList(productVO);
			
		} else {
		    productList = productService.selectProductList(productVO);
		}
		
		
		pagingVO.setBoardCount(productList.size());
		
		model.addAttribute("productList", productList);
		model.addAttribute("productVO", productVO);
		model.addAttribute("pagingVO", pagingVO);
		
		return "product/product";
		
	}
	
	// 상품 상세 페이지 이동
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String productDetail(@PathVariable int productId, 
			ProductVO productVO, Model model) throws Exception {
		
		productVO.setProductId(productId);
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		model.addAttribute("productVO", productList.get(0));
		
		return "product/productDetail";
		
	}
	// 상품 등록 페이지 이동
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String productInsertInit(ProductVO productVO, Model model) {
		
		model.addAttribute("productVO", productVO);
		return "product/productInsert";
		
	}
	// 상품 등록 정보 전송
	@Transactional
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String productInsert(@ModelAttribute ProductVO productVO,
			HttpServletRequest request, @RequestParam MultipartFile file) throws Exception {
		
		String projectPath = "/resources/upload";
		String realPath = request.getSession().getServletContext().getRealPath(projectPath);
		
		File dir = new File(realPath);
		 
		
		String fileName =  file.hashCode() + file.getOriginalFilename();
		System.out.println(fileName);
		String absolutePath = dir.getAbsolutePath() + File.separator  + fileName;
		System.out.println(absolutePath);
		// 파일 전송
		try {
			file.transferTo(new File(absolutePath));
		} catch(Exception e) {
		    System.out.println("업로드 오류");
		    e.printStackTrace();
		}
		
		productVO.setProductThumnail(fileName);
		productService.insertProduct(productVO);
		return "redirect:/product";
		
	}
	
	// 상품 등록 정보 수정
	@GetMapping("/regist/{productId}")
	public String productUpdateInit(@PathVariable int productId, 
		 ProductVO productVO, Model model) throws Exception {
			
		productVO.setProductId(productId);
		ProductVO product = productService.selectProductList(productVO).get(0);
		model.addAttribute("productVO", product);
			
		return "product/productInsert";
			
	}
	
	// 상품 등록 정보 수정
	@PostMapping("/regist/{productId}")
	public String productUpdate(@PathVariable int productId, 
			@ModelAttribute ProductVO productVO) throws Exception {
		
		productVO.setProductId(productId);
		productService.updateProduct(productVO);
		return "redirect:/product/" + productId;
		
	}
	
	// 상품 등록 정보 삭제
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public String productDelete(@PathVariable int productId, 
			ProductVO productVO) throws Exception {
		
		productVO.setProductId(productId);
		productService.deleteProduct(productVO);
		return "redirect:/product";
			
		}

}
