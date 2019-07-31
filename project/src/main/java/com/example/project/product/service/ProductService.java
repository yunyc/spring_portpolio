package com.example.project.product.service;

import java.util.List;

import com.example.project.product.service.VO.ProductVO;

public interface ProductService {
	
	List<ProductVO> selectProductList() throws Exception;
	
	void insertProduct() throws Exception;
	
	void updateProduct() throws Exception;
	
	void deleteProduct() throws Exception;

}
