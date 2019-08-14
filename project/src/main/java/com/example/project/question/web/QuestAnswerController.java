package com.example.project.question.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// 답변 추가 기능
	@PostMapping("/{questId}")
	public String answerInsert(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO, Model model) throws Exception {
		
		questService.insertAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}
	
	// 답변 수정 페이지 초기화 
	@GetMapping("/{questId}/answer/{answerId}")
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
	
	// 답변 수정 기능
	@PatchMapping("/{questId}/answer/{answerId}")
	public String answerUpdate(@PathVariable int questId, @PathVariable int answerId,
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
	    answerVO.setAnswerId(answerId);
		questService.updateAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}	
	
	// 답변 삭제 기능 
	@DeleteMapping("/{questId}/answer/{answerId}")
	public String answerDelete(@PathVariable int questId, @PathVariable int answerId, 
		QuestAnswerVO answerVO) throws Exception {
			
		answerVO.setAnswerId(answerId);
		questService.deleteAnswer(answerVO);
			
		return "redirect:/quest/" + questId;
	}
}
