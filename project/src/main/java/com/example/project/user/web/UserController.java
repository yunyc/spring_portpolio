package com.example.project.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.user.vaildator.SignUpVaildator;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginInit() {
		
		return "user/login";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpInit(Model model) {
		
		UserVO userVO = new UserVO();
        model.addAttribute("userVO", userVO);
		
		return "user/signUp";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@Transactional
	public String userInsert(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute @Valid UserVO userVO, BindingResult result ,Random random) throws Exception {
		
		new SignUpVaildator().validate(userVO, result);
		
		if (result.hasErrors()) {
			return "/user/signUp";
		
		} else {
			String authKey =  Integer.toString(random.nextInt(6));
			userVO.setAuthKey(authKey);
			
			userService.insertUserList(userVO);
			userService.insertAuthority(userVO);
			
			String email = userVO.getUserEmail();
			
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			userService.sendMail(email, userVO.getUserId(), userVO.getAuthKey());
			
			return "redirect:/main.do";
		}
	
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.PATCH)
	public String userUpdate() {
		
		return null;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.DELETE)
	public String userDelete() {
		
		return null;
	}
	
	
	@RequestMapping("/emailConfirm")
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
