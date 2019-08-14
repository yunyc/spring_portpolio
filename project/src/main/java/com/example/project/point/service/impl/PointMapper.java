package com.example.project.point.service.impl;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
	
	// 좋아요, 싫어요, 답변 상태 변경
	void updateState(HashMap<String, Object> map) throws Exception;
	
	void plusPoint(String userId) throws Exception;

}
