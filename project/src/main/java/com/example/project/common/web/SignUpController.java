package com.example.project.common.web;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.common.service.MailService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.vaildator.SignUpVaildator;

@Controller
public class SignUpController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private MailService mailService;
	
	@RequestMapping("/common/signUp.do")
	public String signUpInit(Model model) {
		
		UserVO userVO = new UserVO();
        model.addAttribute("userVO", userVO);
		
		return "common/signUp";
	}
	
	@RequestMapping("/common/signUp/submit.do")
	public String signUpSubmit(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute @Valid UserVO userVO, BindingResult result ,Random random) throws Exception {
		
		new SignUpVaildator().validate(userVO, result);
		
		if (result.hasErrors()) {
			return "/common/signUp";
		
		} else {
			String authKey =  Integer.toString(random.nextInt(6));
			userVO.setAuthKey(authKey);
			String email = userVO.getUserEmail();
			
			userService.insertUserList(userVO);
			userService.insertAuthority(userVO);
			
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			mailService.sendMail(email, userVO.getUserId(), userVO.getAuthKey());
			
			return "redirect:/main.do";
		}
	
	}
	

}
