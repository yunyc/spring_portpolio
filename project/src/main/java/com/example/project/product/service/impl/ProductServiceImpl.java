package com.example.project.product.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;

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

@Service
public class ProductServiceImpl implements ProductService {
	
	/** ProductMapper 인터페이스 */
	@Resource
	private ProductMapper productMapper;
	
	/**
	 * 상품 조회
	 * @param productVO - 검색 옵션 정보가 담긴 ProductVO
	 * @return 상품 조회 결과
	 * @exception Exception
	 */
	@Override
	public List<ProductVO> selectProductList(ProductVO productVO) throws Exception {
		return productMapper.selectProductList(productVO);
	}
	
	/**
	 * 상품 추가
	 * @param productVO - 추가할 질문 정보가 담긴 ProductVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void insertProduct(ProductVO productVO) throws Exception {
		productMapper.insertProduct(productVO);
	}
	
	/**
	 * 상품 수정
	 * @param productVO - 수정할 질문 정보가 담긴 ProductVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void updateProduct(ProductVO productVO) throws Exception {
		productMapper.updateProduct(productVO);	
	}
	
	/**
	 * 상품 삭제
	 * @param productVO - 삭제할 질문 정보가 담긴 QueProductVOstVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteProduct(ProductVO productVO) throws Exception {
		productMapper.deleteProduct(productVO);	
	}
	
	/**
	 * 주문 조회
	 * @param userId - 사용자 아이디
	 * @return void
	 * @exception Exception
	 */
	@Override
	public List<HashMap<String, Object>> selectOrder(String userId) throws Exception {
		return productMapper.selectOrder(userId);
	}
	
	/**
	 * 주문 생성
	 * @param map - 사용자 정보와 상품 정보가 담긴 HashMap
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void insertOrder(HashMap<String, Object> map) throws Exception {
		productMapper.insertOrder(map);		
	}
	
	/**
	 * 주문 취소, 삭제
	 * @param userId - 사용자 아이디
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteOrder(String userId) throws Exception {
		productMapper.deleteOrder(userId);		
	}
	
	

}
