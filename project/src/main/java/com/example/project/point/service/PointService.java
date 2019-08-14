package com.example.project.point.service;

import java.util.HashMap;

public interface PointService {
	
	// 질문 좋아요, 싫어요, 답변 상태 변경
	void updateState(HashMap<String, Object> map) throws Exception;
	
	void plusPoint(HashMap<String, Object> map) throws Exception;
	
}
