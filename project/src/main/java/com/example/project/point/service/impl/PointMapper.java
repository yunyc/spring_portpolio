package com.example.project.point.service.impl;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Class Name : PointMapper.java
 * @Description : PointMapper interface
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

@Mapper
public interface PointMapper {
	
	/**
	 * 질문 좋아요, 싫어요, 답변 상태 변경
	 * @param map - 질문 상태 정보를 받을 HashMap
	 * @return "void"
	 * @exception Exception
	 */
	void updateState(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 포인트 추가 기능
	 * @param map - 사용자 정보를 받을 HashMap
	 * @return "void"
	 * @exception Exception
	 */
	void plusPoint(HashMap<String, Object> map) throws Exception;

}
