package com.example.project.interceptor;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

/**
 * @Class Name : SessionInterceptor.java
 * @Description : SessionInterceptor Class
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

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private UserService userService;
	
	/**
	 * 사용자 세션 정보 업데이트
	 * @param request - 요청 정보 HttpServletRequest
	 * @param response -응답 정보 HttpServletResponse
	 * @param handler
	 * @return super.preHandle(request, response, handler)
	 * @exception Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {


		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		UserVO userVO = new UserVO();
		
		map.put("userId", session.getAttribute("userId"));
		
		try {
			userVO = userService.selectUserList(map).get(0);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		session.setAttribute("userPoint", userVO.getUserPoint());
		super.postHandle(request, response, handler, modelAndView);
	}
	
	

}
