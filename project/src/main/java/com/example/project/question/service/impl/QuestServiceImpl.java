package com.example.project.question.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.point.service.PointService;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;

/**
 * @Class Name : QuestServiceImpl.java
 * @Description : QuestServiceImpl Class
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

@Service
public class QuestServiceImpl implements QuestService {
	
	/** QuestMapper 인터페이스 */
	@Resource
	private QuestMapper questMapper;
	
	/** PointService 인터페이스 */
	@Resource
	private PointService pointService;
	
	/**
	 * 질문 조회
	 * @param questVO - 검색 옵션 정보가 담긴 QuestVO
	 * @return 조회 결과
	 * @exception Exception
	 */
	@Override
	public List<QuestVO> selectQuestList(QuestVO questVO) throws Exception {
		return questMapper.selectQuestList(questVO);
	}
	
	/**
	 * 질문 등록
	 * @param questVO - 등록할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	@Transactional
	public void insertQuest(QuestVO questVO) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", questVO.getUserId());
		map.put("point", 100);
		
		questMapper.insertQuest(questVO);
		pointService.plusPoint(map);
	}
	
	/**
	 * 질문 수정
	 * @param questVO - 수정할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void updateQuest(QuestVO questVO) throws Exception {
		questMapper.updateQuest(questVO);
		
	}
	
	/**
	 * 질문 삭제
	 * @param questVO - 삭제할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteQuest(QuestVO questionVO) throws Exception {
		questMapper.deleteQuest(questionVO);
		
	}
	
	/**
	 * 답변 조회
	 * @param answerVO - 답변 옵션 QuestAnswerVO
	 * @return 조회 결과
	 * @exception Exception
	 */
	@Override
	public List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception {
		return questMapper.selectAnswerList(answerVO);
	}
	
	/**
	 * 답변 등록
	 * @param answerVO - 등록할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void insertAnswer(QuestAnswerVO answerVO) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userId", answerVO.getUserId());
		map.put("point", 200);
		
		questMapper.insertAnswer(answerVO);
		pointService.plusPoint(map);
		
	}
	
	/**
	 * 답변 수정
	 * @param answerVO - 등록할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void updateAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.updateAnswer(answerVO);		
	}
	
	/**
	 * 답변 삭제
	 * @param answerVO - 삭제할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.deleteAnswer(answerVO);
		
	}

}
