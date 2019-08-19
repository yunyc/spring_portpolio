package com.example.project.point.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.project.point.service.PointService;

/**
 * @Class Name : QuestController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author yunyc
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service
public class PointServiceImpl implements PointService {
	
	@Resource
	private PointMapper pointMapper;
	
	/**
	 * 질문 좋아요, 싫어요, 답변 상태 변경
	 * @param map - 질문 상태 정보를 받을 HashMap
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void updateState(HashMap<String, Object> map) throws Exception {
		pointMapper.updateState(map);
	}
	
	/**
	 * 포인트 추가 기능
	 * @param map - 사용자 정보를 받을 HashMap
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void plusPoint(HashMap<String, Object> map) throws Exception {
		pointMapper.plusPoint(map);
		
	}

	
	
	

}
