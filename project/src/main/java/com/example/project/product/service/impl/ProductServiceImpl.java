package com.example.project.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	private ProductMapper productMapper;

	@Override
	@Transactional
	public List<ProductVO> selectProductList(ProductVO productVO) throws Exception {
		return productMapper.selectProductList(productVO);
	}

	@Override
	@Transactional
	public void insertProduct(ProductVO productVO) throws Exception {
		productMapper.insertProduct(productVO);
	}

	@Override
	@Transactional
	public void updateProduct(ProductVO productVO) throws Exception {
		productMapper.updateProduct(productVO);	
	}

	@Override
	@Transactional
	public void deleteProduct(ProductVO productVO) throws Exception {
		productMapper.deleteProduct(productVO);	
	}

}
