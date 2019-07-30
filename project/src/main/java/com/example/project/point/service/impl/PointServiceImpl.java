package com.example.project.point.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.point.service.PointService;

@Service
public class PointServiceImpl implements PointService {
	
	@Resource
	private PointMapper pointMapper;

	@Override
	@Transactional
	public void plusPoint(String userId) throws Exception {
		pointMapper.plusPoint(userId);
	}

	@Override
	public void minusPoint() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
