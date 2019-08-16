package com.example.project.question.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;

@Mapper
public interface QuestMapper {
	
	/**
	 * 질문 조회
	 * @param questVO - 검색 옵션 정보가 담긴 QuestVO
	 * @return 조회 결과
	 * @exception Exception
	 */
	List<QuestVO> selectQuestList(QuestVO questVO) throws Exception;
	
	/**
	 * 질문 등록
	 * @param questVO - 등록할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	void insertQuest(QuestVO questionVO) throws Exception;
	
	/**
	 * 질문 수정
	 * @param questVO - 수정할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	void updateQuest(QuestVO questionVO) throws Exception;
	
	/**
	 * 질문 삭제
	 * @param questVO - 삭제할 질문 정보가 담긴 QuestVO
	 * @return void
	 * @exception Exception
	 */
	void deleteQuest(QuestVO questionVO) throws Exception;
	
	/**
	 * 답변 조회
	 * @param answerVO - 답변 옵션 QuestAnswerVO
	 * @return 조회 결과
	 * @exception Exception
	 */
	List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception;
	
	/**
	 * 답변 등록
	 * @param answerVO - 등록할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	void insertAnswer(QuestAnswerVO answerVO) throws Exception;
	
	/**
	 * 답변 수정
	 * @param answerVO - 등록할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	void updateAnswer(QuestAnswerVO answerVO) throws Exception;
	
	/**
	 * 답변 삭제
	 * @param answerVO - 삭제할 질문 정보가 담긴 QuestAnswerVO
	 * @return void
	 * @exception Exception
	 */
	void deleteAnswer(QuestAnswerVO answerVO) throws Exception;
	
}
