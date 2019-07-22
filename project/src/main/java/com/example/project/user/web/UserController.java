package com.example.project.user.web;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.user.vaildator.SignUpVaildator;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/common/login.do")
	public String loginInit() {
		
		return "user/login";
	}
	
	@RequestMapping("/common/signUp.do")
	public String signUpInit(Model model) {
		
		UserVO userVO = new UserVO();
        model.addAttribute("userVO", userVO);
		
		return "user/signUp";
	}
	
	@RequestMapping("/common/signUp/submit.do")
	public String signUpSubmit(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute @Valid UserVO userVO, BindingResult result ,Random random) throws Exception {
		
		new SignUpVaildator().validate(userVO, result);
		
		if (result.hasErrors()) {
			return "/user/signUp";
		
		} else {
			String authKey =  Integer.toString(random.nextInt(6));
			userVO.setAuthKey(authKey);
			String email = userVO.getUserEmail();
			
			userService.insertUserList(userVO);
			userService.insertAuthority(userVO);
			
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			userService.sendMail(email, userVO.getUserId(), userVO.getAuthKey());
			
			return "redirect:/main.do";
		}
	
	}
	
	@RequestMapping("/user/emailConfirm.do")
	public String emailConfirm(@RequestParam HashMap<String, Object> map) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(map);
		
		System.out.println(map);
		
		if (userList == null) {
			
			return "main/main";
			
		} else {
			userService.updateAuthority(map);
			return "main/main";
		}
		
		
	}

}
