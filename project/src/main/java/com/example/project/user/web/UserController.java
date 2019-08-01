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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.user.vaildator.SignUpVaildator;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	// 로그인 화면 이동
	@RequestMapping("/login")
	public String loginInit() {
		
		return "user/login";
	}
	// 회원가입 이동
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpInit(Model model) {
		
		UserVO userVO = new UserVO();
        model.addAttribute("userVO", userVO);
		
		return "user/signUp";
	}
	// 회원가입 정보 전달, 인증 메일 보내기
	@Transactional
	@RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String userInsert(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute @Valid UserVO userVO, BindingResult result ,Random random) throws Exception {
		
		new SignUpVaildator().validate(userVO, result);
		// 유효성 검사 불통과 시
		if (result.hasErrors()) {
			return "redirect:/signUp";
		// 유효성 검사 통과 시
		} else {
			// 인증키 6자리 생성
			int authKey = (int) Math.floor(Math.random() * 1000000)+100000;
			if(authKey>1000000){
				authKey = authKey - 100000;
			} 
			userVO.setAuthKey(authKey);
			
			// 데이터베이스 업데이트
			userService.insertUserList(userVO);
			userService.insertAuthority(userVO);
			
			// 메일 보내기
			String email = userVO.getUserEmail();
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			userService.sendAuthKey(email, userVO.getUserId(), userVO.getAuthKey());
			
			return "redirect:/login";
		}
	
	}
	
	// 인증 메일 확인
	@RequestMapping("/emailConfirm")
	public String emailConfirm(@RequestParam HashMap<String, Object> map) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(map);
		
		if (userList == null) {
			return "main/main";
		} else {
			userService.updateAuthority(map);
			return "main/main";
		}
	}
	
	// 정보 찾기 페이지로 이동
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findInit(UserVO userVO, Model model) {
			
		model.addAttribute("userVO", userVO);	
		return "user/find";
	}
	
	// 정보 찾기 메일 전송
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(@RequestParam HashMap<String, Object> emailMap, Model model) throws Exception {
		
		String email = (String) emailMap.get("userEmail");
		 
		List<UserVO> userList = userService.selectUserList(emailMap);
		System.out.println(userList.get(0));
		String userId = userList.get(0).getUserId();
		String userPassword = userList.get(0).getPassword();
		
		userService.sendUserInfo(email, userId, userPassword);
				
		return "user/find";
	}

}
