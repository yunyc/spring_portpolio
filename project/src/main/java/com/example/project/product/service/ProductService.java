package com.example.project.product.service;

import java.util.List;
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

public interface ProductService {
	
	/**
	 * 상품 조회
	 * @param productVO - 검색 옵션 정보가 담긴 ProductVO
	 * @return 상품 조회 결과
	 * @exception Exception
	 */
	List<ProductVO> selectProductList(ProductVO productVO) throws Exception;
	
	/**
	 * 상품 추가
	 * @param productVO - 추가할 질문 정보가 담긴 ProductVO
	 * @return void
	 * @exception Exception
	 */
	void insertProduct(ProductVO productVO) throws Exception;
	
	/**
	 * 상품 수정
	 * @param productVO - 수정할 질문 정보가 담긴 ProductVO
	 * @return void
	 * @exception Exception
	 */
	void updateProduct(ProductVO productVO) throws Exception;
	
	/**
	 * 상품 삭제
	 * @param productVO - 삭제할 질문 정보가 담긴 QueProductVOstVO
	 * @return void
	 * @exception Exception
	 */
	void deleteProduct(ProductVO productVO) throws Exception;

}
