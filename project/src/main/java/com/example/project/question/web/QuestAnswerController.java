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
import com.example.project.question.service.VO.QuestVO;

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
		
	// 답변 정보 삭제 
	@RequestMapping(value="/{questId}", method = RequestMethod.DELETE)
	public String answerDelete(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
		answerVO.setQuestId(questId);
		questService.deleteAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}
	
	// 답변 수정 페이지로 이동 
	@RequestMapping(value="/{questId}/answer/{answerId}", method = RequestMethod.GET)
	public String answerUpdateInit(@PathVariable int questId, @PathVariable int answerId, 
			QuestVO questVO, QuestAnswerVO answerVO, Model model) throws Exception {
			
		questVO.setQuestId(questId);
		questVO = questService.selectQuestList(questVO).get(0);
		
		answerVO.setAnswerId(answerId);
		answerVO = questService.selectAnswerList(answerVO).get(0);
		
		model.addAttribute("questVO", questVO);
		model.addAttribute("answerVO", answerVO);
			
		return "quest/answerUpdate";
	}
	
	// 답변 정보 수정
	@RequestMapping(value="/{questId}/answer/{answerId}", method = RequestMethod.PATCH)
	public String answerUpdate(@PathVariable int questId, @PathVariable int answerId,
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
	    answerVO.setAnswerId(answerId);
		questService.updateAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}
	
	// 답변 채택 처리
	@RequestMapping(value="/select", method = RequestMethod.POST)
	public void answerSelect() throws Exception {
		
	    System.out.println("성공");
	}
		
}
