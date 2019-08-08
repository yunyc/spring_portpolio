package com.example.project.question.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;

@Controller
@RequestMapping("/quest")
public class QuestAnswerController {
	
	@Resource
	private QuestService questService;
	
	// 답변 정보 생성
	@RequestMapping(value="/{questId}", method = RequestMethod.POST)
	public String answerInsert(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO, Model model) throws Exception {
		
		questService.insertAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}
	
	// 답변 정보 수정
	@RequestMapping(value="/{questId}", method = RequestMethod.PATCH)
	public String answerUpdate(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
		questService.updateAnswer(answerVO);
		
		return "quest/questDetail";
	}
		
	// 답변 정보 삭제 
	@RequestMapping(value="/{productId}", method = RequestMethod.DELETE)
	public String answerDelete(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
		questService.deleteAnswer(answerVO);
		
		return "quest/questDetail";
	}
		
}
