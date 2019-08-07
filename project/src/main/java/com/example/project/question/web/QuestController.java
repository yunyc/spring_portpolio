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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestVO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.gson.Gson;
import com.google.gson.JsonObject;



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
	
	// 질문 ajax로 로딩
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public HashMap<String, Object> questLoad(QuestVO questVO, Model model) throws Exception {
			
		List<QuestVO> questList = questService.selectQuestList(questVO);
		/*
		Gson gson = new Gson();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("questList", questList);
		String jsonstring = gson.toJson(map);
		System.out.println(gson.toJson(questVO));
		*/
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("questList", questList);
		return map;
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
	public String questInsert(@ModelAttribute QuestVO questVO, 
			Model model) throws Exception {
		
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
