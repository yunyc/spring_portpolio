package com.example.project.point.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.point.service.PointService;

/**
 * @Class Name : PointController.java
 * @Description : PointController Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

@RestController
@RequestMapping("/point")
public class PointController {
	
	@Resource
	private PointService pointService;
	
	/**
	 * (Ajax 처리) 질문 상세보기 페이지 좋아요, 싫어요, 채택하기 기능
	 * @param map - 질문 상태 정보를 담은 HashMap
	 * @return "map"
	 * @exception Exception
	 */
	@ResponseBody
	@PatchMapping("/state")
	public HashMap<String, Object> updateQuest(@RequestBody HashMap<String, Object> map) throws Exception {
		
		pointService.updateState(map);
		return map;
	}
	
}
