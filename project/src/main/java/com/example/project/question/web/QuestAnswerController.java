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

import com.example.project.product.service.ProductService;
import com.example.project.product.service.VO.ProductVO;
import com.example.project.question.service.QuestService;
import com.example.project.question.service.VO.QuestAnswerVO;
import com.example.project.question.service.VO.QuestVO;

/**
 * @Class Name : QuestAnswerController.java
 * @Description : QuestAnswerController Class
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
public class QuestAnswerController {
	
	/** QuestService 주입 */
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
	 * 답변 추가 기능
	 * @param answerVO - 답변 정보가 담긴 QuestVO
	 * @param questId - 질문 번호
	 * @param model
	 * @return "redirect:/quest/" + questId
	 * @exception Exception
	 */
	@PostMapping("/{questId}")
	public String answerInsert(@PathVariable int questId, 
			@ModelAttribute QuestAnswerVO answerVO, Model model) throws Exception {
		
		questService.insertAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}
	
	/**
	 * 답변 수정 페이지로 이동
	 * @param answerId - 답변 번호
	 * @param questId - 질문 번호
	 * @param questVO - 질문 정보가 담긴 QuestVO
	 * @param answerVO - 답변 정보가 담긴 QuestAnswerVO
	 * @param model
	 * @return answerUpdate
	 * @exception Exception
	 */
	@GetMapping("/{questId}/answer/{answerId}")
	public String answerUpdateInit(@PathVariable int questId, @PathVariable int answerId, 
			QuestVO questVO, QuestAnswerVO answerVO, Model model) throws Exception {
			
		questVO.setQuestId(questId);
		answerVO.setAnswerId(answerId);
		
		try {
			questVO = questService.selectQuestList(questVO).get(0);
			answerVO = questService.selectAnswerList(answerVO).get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("questVO", questVO);
		model.addAttribute("answerVO", answerVO);
			
		return "quest/answerUpdate";
	}
	
	/**
	 * 답변 수정 기능
	 * @param answerId - 답변 번호
	 * @param questId - 질문 번호
	 * @param answerVO - 답변 정보가 담긴 QuestAnswerVO
	 * @return "redirect:/quest/" + questId
	 * @exception Exception
	 */
	@PatchMapping("/{questId}/answer/{answerId}")
	public String answerUpdate(@PathVariable int questId, @PathVariable int answerId,
			@ModelAttribute QuestAnswerVO answerVO) throws Exception {
		
	    answerVO.setAnswerId(answerId);
	    
		questService.updateAnswer(answerVO);
		
		return "redirect:/quest/" + questId;
	}	
	
	/**
	 * 답변 삭제 기능
	 * @param answerId - 답변 번호
	 * @param questId - 질문 번호
	 * @param answerVO - 답변 정보가 담긴 QuestAnswerVO
	 * @return "redirect:/quest/" + questId
	 * @exception Exception
	 */
	@DeleteMapping("/{questId}/answer/{answerId}")
	public String answerDelete(@PathVariable int questId, @PathVariable int answerId, 
		QuestAnswerVO answerVO) throws Exception {
			
		answerVO.setAnswerId(answerId);
		
		questService.deleteAnswer(answerVO);
			
		return "redirect:/quest/" + questId;
	}
}
