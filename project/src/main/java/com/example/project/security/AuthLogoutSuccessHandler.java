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
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.project.point.service.PointService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

/**
 * @Class Name : AuthLogoutSuccessHandler.java
 * @Description : AuthLogoutSuccessHandler Class
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

public class AuthLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	/**
	 * 로그 아웃 후 페이지 유지
	 * @param request - 요청 정보 HttpServletRequest
	 * @param response - 응답 정보 HttpServletResponse
	 * @param authentication - 사용자 인증 정보 Authentication
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
		
		super.onLogoutSuccess(request, response, authentication);
		
		
	}
	
	
	

}
