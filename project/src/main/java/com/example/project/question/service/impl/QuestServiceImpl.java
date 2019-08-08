package com.example.project.question.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;


@Service
public class QuestServiceImpl implements QuestService {
	
	@Resource
	private QuestMapper questMapper;

	@Override
	public List<QuestVO> selectQuestList(QuestVO questVO) throws Exception {
		return questMapper.selectQuestList(questVO);
	}

	@Override
	public void insertQuest(QuestVO questVO) throws Exception {
		questMapper.insertQuest(questVO);
	}

	@Override
	public void updateQuest(QuestVO questVO) throws Exception {
		questMapper.updateQuest(questVO);
		
	}

	@Override
	public void deleteQuest(QuestVO questionVO) throws Exception {
		questMapper.deleteQuest(questionVO);
		
	}

	@Override
	public List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception {
		return questMapper.selectAnswerList(answerVO);
	}

	@Override
	public void insertAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.insertAnswer(answerVO);
		
	}

	@Override
	public void updateAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.updateAnswer(answerVO);		
	}

	@Override
	public void deleteAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.deleteAnswer(answerVO);
		
	}

}
