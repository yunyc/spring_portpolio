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
import com.example.project.question.service.VO.QuestVO;



@Controller
@RequestMapping("/quest")
public class QuestController {
	
	@Resource
	private QuestService questService;
	// 질문 목록
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String questInit(QuestVO questVO, Model model) throws Exception {
		
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questList", questList);
		
		return "quest/quest";
	}
	
	// 질문 상세보기
	@RequestMapping(value = "/{questId}", method = RequestMethod.GET)
	public String questDetailInit(@PathVariable int questId, 
			QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questVO", questList.get(0));
		
		return "quest/questDetail";
	}
	
	// 질문하기 페이지로 이동
	@RequestMapping(value = "/post" , method = RequestMethod.GET)
	public String questInsertInit(QuestVO questVO, Model model) throws Exception {
		
		model.addAttribute("questVO", questVO);
		model.addAttribute("method", "post");
		
		return "quest/questInsert";
	}
	
	// 질문하기
	@RequestMapping(value = "/post" , method = RequestMethod.POST)
	public String questInsert(@ModelAttribute QuestVO questVO, Model model) throws Exception {
		
		questService.insertQuest(questVO);
		
		return "redirect:/quest";
	}
	
	// 질문 쓰기 페이지로 이동
	@RequestMapping(value = "/post/{questId}" , method = RequestMethod.POST)
	public String questUpdateInit(@PathVariable int questId, QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questVO", questList.get(0));
		model.addAttribute("method", "patch");
			
		return "quest/questInsert";
	}
		
	// 질문 수정
	@RequestMapping(value = "/post/{questId}", method = RequestMethod.PATCH)
	public String questUpdate(@ModelAttribute QuestVO questVO, Model model) throws Exception {
		
		questService.updateQuest(questVO);
		
		return "redirect:/quest";
	}
	// 질문 삭제
	@RequestMapping(value = "/post/{questId}", method = RequestMethod.DELETE)
	public String questDeleteInit(@PathVariable int questId, 
			QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		questService.deleteQuest(questVO);
		
		return "redirect:/quest";
	}
	

}
