package com.example.project.question.service;

import java.util.List;

import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;


public interface QuestService {
	
	List<QuestVO> selectQuestList(QuestVO questVO) throws Exception;
	
	void insertQuest(QuestVO questVO) throws Exception;
	
	void updateQuest(QuestVO questVO) throws Exception;
	
	void deleteQuest(QuestVO questVO) throws Exception;
	
	
	List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception;
	
	void insertAnswer(QuestAnswerVO answerVO) throws Exception;
	
	void updateAnswer(QuestAnswerVO answerVO) throws Exception;
	
	void deleteAnswer(QuestAnswerVO answerVO) throws Exception;
	

}
