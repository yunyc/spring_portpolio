package com.example.project.question.service.impl;

import java.util.HashMap;
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
	
	// 질문 조회
	@Override
	public List<QuestVO> selectQuestList(QuestVO questVO) throws Exception {
		return questMapper.selectQuestList(questVO);
	}
	
	// 질문 생성
	@Override
	public void insertQuest(QuestVO questVO) throws Exception {
		questMapper.insertQuest(questVO);
	}
	
	// 질문 수정
	@Override
	public void updateQuest(QuestVO questVO) throws Exception {
		questMapper.updateQuest(questVO);
		
	}
	
	// 질문 삭제
	@Override
	public void deleteQuest(QuestVO questionVO) throws Exception {
		questMapper.deleteQuest(questionVO);
		
	}
	
	// 답변 조회
	@Override
	public List<QuestAnswerVO> selectAnswerList(QuestAnswerVO answerVO) throws Exception {
		return questMapper.selectAnswerList(answerVO);
	}
	
	// 답변 생성
	@Override
	public void insertAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.insertAnswer(answerVO);
		
	}
	
	// 답변 수정
	@Override
	public void updateAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.updateAnswer(answerVO);		
	}
	
	// 답변 삭제
	@Override
	public void deleteAnswer(QuestAnswerVO answerVO) throws Exception {
		questMapper.deleteAnswer(answerVO);
		
	}
	
	// 질문 상태 변경
	@Override
	public void updateState(HashMap<String, Object> map) throws Exception {
		questMapper.updateState(map);
	}

}
