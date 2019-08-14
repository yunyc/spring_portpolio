package com.example.project.question.web;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Multipart;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.gson.Gson;
import com.google.gson.JsonObject;



@Controller
@RequestMapping("/quest")
public class QuestController {
	
	@Resource
	private QuestService questService;
	// 질문 조회 페이지 초기화
	@GetMapping("")
	public String questInit(@RequestParam(defaultValue = "wait") String mode, QuestVO questVO, Model model) throws Exception {
		List<QuestVO> questList = null;
		
		if (mode.equals("wait")) {
			questVO.setQuestState("답변 대기");
		    questList = questService.selectQuestList(questVO);

		} else if (mode.equals("finish")) {
			questVO.setQuestState("답변 완료");
			questList = questService.selectQuestList(questVO);
		}
			
		model.addAttribute("questList", questList);
		
		return "quest/quest";
	}
	
	// (Ajax 처리) 질문 조회 페이지 5개 더보기 기능 
	@ResponseBody
	@PostMapping("")
	public HashMap<String, Object> questLoad(QuestVO questVO, Model model) throws Exception {
			
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("questList", questList);
		return map;
	}
	
	// 질문 상세보기 페이지 초기화
	@GetMapping("/{questId}")
	public String questDetailInit(@PathVariable int questId, 
			QuestVO questVO, QuestAnswerVO answerVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		answerVO.setQuestId(questId);
		List<QuestAnswerVO> answerList = questService.selectAnswerList(answerVO);

		if (answerList.size() > 0 ) {
			model.addAttribute("answerList", answerList);
		}
		
		if (questList.size() > 0 ) {
			model.addAttribute("questVO", questList.get(0));
		}
		model.addAttribute("answerVO",  answerVO);
		return "quest/questDetail";
	}
	
	// 질문 추가 페이지 초기화(생성용)
	@GetMapping("/post")
	public String questInsertInit(QuestVO questVO, Model model) throws Exception {
		
		model.addAttribute("questVO", questVO);
		model.addAttribute("method", "post");
		
		return "quest/questInsert";
	}
	
	// 질문 추가 기능
	@PostMapping("/post")
	public String questInsert(@ModelAttribute QuestVO questVO, 
			Model model) throws Exception {
		
		questService.insertQuest(questVO);
		
		return "redirect:/quest";
	}
	
	// 질문 수정 페이지 초기화(수정용)
	@PostMapping("/post/{questId}")
	public String questUpdateInit(@PathVariable int questId, QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questVO", questList.get(0));
		model.addAttribute("method", "patch");
			
		return "quest/questInsert";
	}
		
	// 질문 수정 기능
	@PatchMapping("/post/{questId}")
	public String questUpdate(@ModelAttribute QuestVO questVO, Model model) throws Exception {
		
		questService.updateQuest(questVO);
		
		return "redirect:/quest";
	}
	
	// 질문 삭제 기능
	@DeleteMapping("/post/{questId}")
	public String questDeleteInit(@PathVariable int questId, 
			QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		questService.deleteQuest(questVO);
		
		return "redirect:/quest";
	}
	

}
