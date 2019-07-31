package com.example.project.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	private ProductMapper productMapper;

	@Override
	public List<ProductVO> selectProductList() throws Exception {
		return productMapper.selectProductList();
	}

	@Override
	public void insertProduct() throws Exception {
		productMapper.insertProduct();
	}

	@Override
	public void updateProduct() throws Exception {
		productMapper.updateProduct();	
	}

	@Override
	public void deleteProduct() throws Exception {
		productMapper.deleteProduct();	
	}

}
