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


@Service
public class QuestServiceImpl implements QuestService {
	
	@Resource
	private QuestMapper questMapper;
	
	@Resource
	private PointService pointService;
	
	// 질문 조회
	@Override
	public List<QuestVO> selectQuestList(QuestVO questVO) throws Exception {
		return questMapper.selectQuestList(questVO);
	}
	
	// 질문 생성
	@Override
	@Transactional
	public void insertQuest(QuestVO questVO) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", questVO.getUserId());
		map.put("point", 100);
		
		questMapper.insertQuest(questVO);
		pointService.plusPoint(map);
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
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", answerVO.getUserId());
		map.put("point", 200);
		
		questMapper.insertAnswer(answerVO);
		pointService.plusPoint(map);
		
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

}
