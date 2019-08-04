package com.example.project.question.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.question.service.VO.QuestVO;

@Mapper
public interface QuestMapper {
	
	List<QuestVO> selectQuestList(QuestVO questVO) throws Exception;
	
	void insertQuest(QuestVO questionVO) throws Exception;
	
	void updateQuest(QuestVO questionVO) throws Exception;
	
	void deleteQuest(QuestVO questionVO) throws Exception;

}