package com.example.project.point.service.impl;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
	
	void plusPoint(String userId) throws Exception;

}
