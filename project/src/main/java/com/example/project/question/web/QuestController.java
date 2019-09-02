package com.example.project.question.web;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Multipart;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;

/**
 * @Class Name : QuestController.java
 * @Description : QuestController Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

@Controller
@RequestMapping("/quest")
public class QuestController {
	
	private static List<QuestVO> questList;
	
	/** QuestService 인터페이스 */
	@Resource
	private QuestService questService;
	
	@Resource
	private ProductService productService;
	
	@ModelAttribute("bestQuestList")
	public List<QuestVO> sideQuestInit(QuestVO questVO) throws Exception {
		
		questVO.setQuestGood(1);
		return questService.selectQuestList(questVO);
		
	}
	
	@ModelAttribute("bestProductList")
	public List<ProductVO> sideProductInit(ProductVO productVO) throws Exception {
		
		productVO.setProductGood(1);
		return productService.selectProductList(productVO);
	}
	
	/**
	 * 질문 목록을 조회
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param model
	 * @return "quest"
	 * @exception Exception
	 */
	@GetMapping("")
	public String questInit(@ModelAttribute QuestVO questVO, 
			Model model) throws Exception {
		
		questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questList", questList);
		
		return "quest/quest";
	}
	
	/**
	 * 질문 목록 5개 더보기
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @return map - 조회한 질문 정보
	 * @exception Exception
	 */
	@ResponseBody
	@PostMapping("")
	public HashMap<String, Object> questLoad(QuestVO questVO) throws Exception {
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("questList", questList);
		
		return map;
	}
	
	/**
	 * 질문 상세정보를 조회
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param questId - 질문 번호
	 * @param answerVO - 답변 정보가 담긴 QuestAnswerVO
	 * @return "questDetail"
	 * @exception Exception
	 */
	@GetMapping("/{questId}")
	public String questDetailInit(@PathVariable int questId, 
			QuestVO questVO, QuestAnswerVO answerVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		answerVO.setQuestId(questId);
		
		try {
			questVO = questService.selectQuestList(questVO).get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			questVO.setQuestState("답변 완료");
			questVO = questService.selectQuestList(questVO).get(0);
		}
		
		List<QuestAnswerVO> answerList = questService.selectAnswerList(answerVO);

		model.addAttribute("answerList", answerList);
		model.addAttribute("questVO", questVO);
		model.addAttribute("answerVO",  answerVO);
		
		return "quest/questDetail";
	}
	
	/**
	 * 질문 추가 페이지로 이동(생성용)
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param model
	 * @return "questInsert"
	 * @exception Exception
	 */
	@GetMapping("/post")
	public String questInsertInit(QuestVO questVO, Model model) throws Exception {
		
		model.addAttribute("questVO", questVO);
		model.addAttribute("method", "post");
		
		return "quest/questInsert";
	}
	
	/**
	 * 질문 추가 기능
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param model
	 * @return "quest"
	 * @exception Exception
	 */
	@PostMapping("/post")
	public String questInsert(@ModelAttribute @Valid QuestVO questVO, 
			Model model) throws Exception {
		
		questService.insertQuest(questVO);
		
		return "redirect:/quest";
	}
	
	/**
	 * 질문 수정 페이지로 이동(수정용)
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param questId - 질문 번호
	 * @param model
	 * @return "questInsert"
	 * @exception Exception
	 */
	@GetMapping("/post/{questId}")
	public String questUpdateInit(@PathVariable int questId, QuestVO questVO, 
			Model model) throws Exception {
		
		questVO.setQuestId(questId);
		List<QuestVO> questList = questService.selectQuestList(questVO);
		
		model.addAttribute("questVO", questList.get(0));
		model.addAttribute("method", "patch");
			
		return "quest/questInsert";
	}
		
	/**
	 * 질문 수정 기능
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param questId - 질문 번호
	 * @param model
	 * @return "redirect:/quest/" + questId
	 * @exception Exception
	 */
	@PatchMapping("/post/{questId}")
	public String questUpdate(@ModelAttribute @Valid QuestVO questVO, 
			@PathVariable int questId, Model model) throws Exception {
		
		questService.updateQuest(questVO);
		
		return "redirect:/quest/" + questId;
	}
	
	/**
	 * 질문 삭제 기능
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param questId - 질문 번호
	 * @param model
	 * @return "quest"
	 * @exception Exception
	 */
	@DeleteMapping("/{questId}")
	public String questDeleteInit(@PathVariable int questId, 
			QuestVO questVO, Model model) throws Exception {
		
		questVO.setQuestId(questId);
		questService.deleteQuest(questVO);
		
		return "redirect:/quest";
	}
	

}
