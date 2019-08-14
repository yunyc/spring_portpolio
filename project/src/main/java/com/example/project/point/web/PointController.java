package com.example.project.point.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.point.service.PointService;

@RestController
@RequestMapping("/point")
public class PointController {
	
	@Resource
	private PointService pointService;
	
	// (Ajax 처리) 질문 상세보기 페이지 좋아요, 싫어요, 채택하기 기능
	@PutMapping("/quest")
	public HashMap<String, Object> updateQuest(@RequestBody HashMap<String, Object> map) throws Exception {
		
		pointService.updateState(map);
		return map;
	}
	
	
}
