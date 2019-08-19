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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.user.vaildator.SignUpVaildator;

/**
 * @Class Name : QuestController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author yunyc
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class UserController {
	/** UserService 인터페이스 */
	@Resource
	private UserService userService;
	
	/**
	 * 로그인 화면 이동
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @param model
	 * @return "login"
	 * @exception Exception
	 */
	@GetMapping("/login")
	public String loginInit(UserVO userVO, Model model) {
		
        model.addAttribute("userVO", userVO);
		
		return "user/login";
	}

	/**
	 * 회원가입 창 띄우기
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @param model
	 * @return "signUp"
	 * @exception Exception
	 */
	@GetMapping("/signup")
	public String signUpInit(UserVO userVO, Model model) {
		
        model.addAttribute("userVO", userVO);
		
		return "user/new/signUp";
	}

	/**
	 * 회원가입 정보 전송, 인증 메일 보냄
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @param req - 요청 정보 HttpServletRequest
	 * @param res - 응답 정보 HttpServletResponse
	 * @param result - 에러 결과 BindingResult
	 * @parma random - 랜덤 Random
	 * @return "메일을 전송했습니다."
	 * @exception Exception
	 */
	@Transactional
	@PostMapping("/signup")
	public String userInsert(HttpServletRequest req, HttpServletResponse res, 
			@ModelAttribute @Valid UserVO userVO, BindingResult result ,Random random) throws Exception {
		
		new SignUpVaildator().validate(userVO, result);
		
		// 유효성 검사 불통과 시
		if (result.hasErrors()) {
			return "user/new/signUp";
		
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
			
			return "메일을 전송했습니다.";
		}
	
	}
	
	/**
	 * 인증 메일 확인 후 사용자 권한 업데이트
	 * @param map - 요청 정보를 받을 HashMap
	 * @return "main"
	 * @exception Exception
	 */
	@RequestMapping("/emailconfirm")
	public String emailConfirm(@RequestParam HashMap<String, Object> map) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(map);
		
		if (userList != null) {
			userService.updateAuthority(map);
		}
		return "main/main";
	}
	
	/**
	 * 정보 찾기 창 띄우기
	 * @param userVO - form 태그와 연결할 UserVO
	 * @param model
	 * @return "find"
	 * @exception Exception
	 */
	@GetMapping("/find")
	public String findInit(UserVO userVO, Model model) {
			
		model.addAttribute("userVO", userVO);	
		return "user/new/find";
	}
	
	/**
	 * 정보 찾기 메일 전송
	 * @param emailMap - form 요청 정보를 받을 HashMap
	 * @param model
	 * @return "확인 메일이 전송되었습니다"
	 * @exception Exception
	 */
	@ResponseBody
	@PostMapping("/find")
	public String find(@RequestParam HashMap<String, Object> emailMap, Model model) throws Exception {
		
		String email = (String) emailMap.get("userEmail");
		 
		List<UserVO> userList = userService.selectUserList(emailMap);
		
		String userId = userList.get(0).getUserId();
		String userPassword = userList.get(0).getUserPassword();
		
		userService.sendUserInfo(email, userId, userPassword);
				
		return "확인 메일이 전송되었습니다";
	}

}
