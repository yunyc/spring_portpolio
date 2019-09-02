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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.project.file_upload.FileVO;
import com.example.project.paging.PagingVO;
import com.example.project.point.service.PointService;
import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;

/**
 * @Class Name : ProductController.java
 * @Description : ProductController Class
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
@RequestMapping("/product")
public class ProductController {
	/** QuestService 인터페이스 */
	@Resource
	private ProductService productService;
	
	@Resource
	private PointService pointService;
	
	@Resource
	private QuestService questService;
	
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
	 * 상품 목록을 조회
	 * @param pagingVO - 페이징 정보가 담긴 PagingVO
	 * @param productVO - 상품 정보가 담긴 ProductVO
	 * @param model
	 * @return "product"
	 * @exception Exception
	 */
	@GetMapping("")
	public String productInit(@ModelAttribute PagingVO pagingVO, 
			@ModelAttribute ProductVO productVO, Model model) throws Exception {
		
		List<ProductVO> productList = productService.selectProductList(productVO);
		
		pagingVO.setIndexSize(6);
		pagingVO.setBoardCount(productList.size());
		pagingVO.setPageSize(10);
	
		model.addAttribute("productList", productList);
		model.addAttribute("productVO", productVO);
		model.addAttribute("pagingVO", pagingVO);
		
		return "product/product";
		
	}
	
	/**
	 * 상품 상세 페이지로 이동
	 * @param productId - 상품 번호
	 * @param productVO - 상품 정보가 담긴 ProductVO
	 * @param model
	 * @return "productDetail"
	 * @exception Exception
	 */
	@GetMapping("/{productId}")
	public String productDetail(@PathVariable int productId, 
			ProductVO productVO, Model model) throws Exception {
		
		try {
			productVO.setProductId(productId);
			productVO = productService.selectProductList(productVO).get(0);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("productVO", productVO);
		
		return "product/productDetail";
		
	}

	/**
	 * 상품 등록 페이지로 이동
	 * @param productVO - 상품 정보가 담긴 ProductVO
	 * @param model
	 * @return "productInsert"
	 * @exception Exception
	 */
	@GetMapping("/regist")
	public String productRegistInit(ProductVO productVO, Model model) {
		
		model.addAttribute("productVO", productVO);
		model.addAttribute("mode", "insert");
		return "product/productInsert";
	}

	/**
	 * 상품 등록 정보 전송
	 * @param productVO - 상품 정보가 담긴 ProductVO
	 * @param file - 전송된 파일 정보 MultipartFile
	 * @param request - 요청 정보 HttpServletRequest
	 * @param fileVO - 파일 처리 관련 정보 FileVO
	 * @return "product"
	 * @exception Exception
	 */
	@Transactional
	@PostMapping("/regist")
	public String productInsert(@ModelAttribute @Valid ProductVO productVO, FileVO fileVO,
			HttpServletRequest req, @RequestParam MultipartFile file) throws Exception {
		
		fileVO.setUpload(file);
		fileVO.setFileUpload(req);
		
		try {
			file.transferTo(new File(fileVO.getUploadPath()));
			
		} catch(Exception e) {
		    System.out.println("업로드 오류");
		    e.printStackTrace();
		}
		
		productVO.setProductThumnail(fileVO.getFileName());
		
		productService.insertProduct(productVO);
		
		return "redirect:/product";
		
	}
	
	/**
	 * 상품 정보 수정 페이지 이동
	 * @param productId - 상품 번호
	 * @param productVO - 상품 관련 정보 ProductVO
	 * @param model
	 * @return "productInsert"
	 * @exception Exception
	 */
	@GetMapping("/regist/{productId}")
	public String productUpdateInit(@PathVariable int productId, 
		 ProductVO productVO, Model model) throws Exception {
			
		try {
			productVO.setProductId(productId);
			productVO = productService.selectProductList(productVO).get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("productVO", productVO);
		model.addAttribute("mode", "update");
			
		return "product/productInsert";
			
	}
	
	/**
	 * 상품 정보 수정
	 * @param productId - 상품 번호
	 * @param productVO - 상품 관련 정보 ProductVO
	 * @param file - 전송된 파일 정보 FileVO
	 * @param fileVO - 파일 처리 관련 정보 MultipartFile
	 * @param req - 요청 정보 HttpServletRequest
	 * @return "redirect:/product/" + productId
	 * @exception Exception
	 */
	@Transactional
	@PostMapping("/regist/{productId}")
	public String productUpdate(@PathVariable int productId, @RequestParam MultipartFile file, 
			@ModelAttribute @Valid ProductVO productVO, FileVO fileVO, HttpServletRequest req) throws Exception {
		
		fileVO.setUpload(file);
		fileVO.setFileUpload(req);
		
		try {
			file.transferTo(new File(fileVO.getUploadPath()));
			
		} catch(Exception e) {
		    System.out.println("업로드 오류");
		    e.printStackTrace();
		}
		
		productVO.setProductThumnail(fileVO.getFileName());
		productVO.setProductId(productId);
		
		productService.updateProduct(productVO);
		return "redirect:/product/" + productId;
		
	}
	
	/**
	 * 상품 정보 삭제
	 * @param productId - 상품 번호
	 * @param productVO - 상품 관련 정보 ProductVO
	 * @return "redirect:/product"
	 * @exception Exception
	 */
	@DeleteMapping("/{productId}")
	public String productDelete(@PathVariable int productId, 
			ProductVO productVO) throws Exception {
		
		productVO.setProductId(productId);
		
		productService.deleteProduct(productVO);
		
		return "redirect:/product";
	}
	
	/**
	 * 상품 구매하기
	 * @param orderMap - 상품 정보
	 * @return void
	 * @exception Exception
	 */
	@Transactional
	@ResponseBody
	@PostMapping("/purchase")
	public void productPurchase(@RequestBody HashMap<String, Object> orderMap) 
			throws Exception {
		
		// 포인트 차감
		pointService.plusPoint(orderMap);
		// 주문 추가
		productService.insertOrder(orderMap);
	}
}
