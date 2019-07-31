package com.example.project.product.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.product.service.VO.ProductVO;

@Mapper
public interface ProductMapper {
	
	List<ProductVO> selectProductList() throws Exception;
	
	void insertProduct() throws Exception;
	
	void updateProduct() throws Exception;
	
	void deleteProduct() throws Exception;
}
