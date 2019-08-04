package com.example.project.product.service;

import java.util.List;

import com.example.project.product.service.VO.ProductVO;

public interface ProductService {
	
	List<ProductVO> selectProductList(ProductVO productVO) throws Exception;
	
	void insertProduct(ProductVO productVO) throws Exception;
	
	void updateProduct(ProductVO productVO) throws Exception;
	
	void deleteProduct(ProductVO productVO) throws Exception;

}
