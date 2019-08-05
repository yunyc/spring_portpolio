package com.example.project.product.web;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String productInit(@ModelAttribute ProductVO productVO, Model model) throws Exception {
		
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		model.addAttribute("productList", productList);
		model.addAttribute("productVO", productVO);
		
		return "product/product";
		
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
			HttpServletRequest request, MultipartHttpServletRequest mtf) throws Exception {
		
		String fileTag = "file";
		String projectPath = "/resources/upload";
		String realPath = request.getSession().getServletContext().getRealPath(projectPath);
		
		File dir = new File(realPath);
		 
		MultipartFile file = mtf.getFile(fileTag);
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
