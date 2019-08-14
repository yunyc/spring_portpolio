package com.example.project.question.service;

import java.util.HashMap;
import java.util.List;

import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;


public interface QuestService {
	
	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	List<QuestVO> selectQuestList(QuestVO questVO) throws Exception;
	
	void insertQuest(QuestVO questVO) throws Exception;
	
	void updateQuest(QuestVO questVO) throws Exception;
	
	void deleteQuest(QuestVO questVO) throws Exception;
	
	// 답변 조회, 생성, 수정, 삭제
	List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception;
	
	void insertAnswer(QuestAnswerVO answerVO) throws Exception;
	
	void updateAnswer(QuestAnswerVO answerVO) throws Exception;
	
	void deleteAnswer(QuestAnswerVO answerVO) throws Exception;
	
}
