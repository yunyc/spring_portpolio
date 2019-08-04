package com.example.project.product.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.product.service.VO.ProductVO;

@Mapper
public interface ProductMapper {
	
	List<ProductVO> selectProductList(ProductVO productVO) throws Exception;
	
	void insertProduct(ProductVO productVO) throws Exception;
	
	void updateProduct(ProductVO productVO) throws Exception;
	
	void deleteProduct(ProductVO productVO) throws Exception;
}
