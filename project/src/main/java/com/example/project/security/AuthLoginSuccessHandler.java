package com.example.project.security;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.project.point.service.PointService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

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

public class AuthLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Resource
	private UserService userService;
	
	/**
	 * 사용자 정보 세션 등록
	 * @param request - 요청 정보 HttpServletRequest
	 * @param response - 응답 정보 HttpServletResponse
	 * @param authentication - 사용자 인증 정보 Authentication
	 * @return "redirect:/product"
	 * @exception Exception
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
	
	HttpSession session = request.getSession();
	HashMap<String, Object> map = new HashMap<String, Object>();
	UserVO userVO = new UserVO();
	
	map.put("userId", authentication.getName());
	
	try {
		userVO = userService.selectUserList(map).get(0);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
	session.setAttribute("userId", authentication.getName());
	session.setAttribute("userPoint", userVO.getUserPoint());
	session.setAttribute("userLevel", userVO.getUserLevel());
	
	response.sendRedirect("/main.do");
	
	}

}
