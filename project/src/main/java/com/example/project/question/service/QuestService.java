package com.example.project.question.service;

import java.util.List;

import com.example.project.question.service.VO.QuestVO;


public interface QuestService {
	
	List<QuestVO> selectQuestList(QuestVO questVO) throws Exception;
	
	void insertQuest(QuestVO questVO) throws Exception;
	
	void updateQuest(QuestVO questVO) throws Exception;
	
	void deleteQuest(QuestVO questVO) throws Exception;

}
