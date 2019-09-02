package com.example.project.vaildator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.product.service.ProductService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;
import com.example.project.user.service.impl.UserServiceImpl;

/**
 * @Class Name : SignUpVaildator.java
 * @Description : SignUpVaildator Class
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

public class SignUpVaildator implements Validator {
	
	private UserService userService;
	
	public SignUpVaildator(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}
	
	/**
	 * 로그인 시 유효성 검사
	 * @param target - 검사 대상 객체인 Object
	 * @param errors - 에러를 담을 Errors
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO = (UserVO) target;
		
		// 비밀번호 확인
		if (!userVO.getPasswordConfirm().equals(userVO.getUserPassword())) {
			errors.rejectValue("userPassword", "passwordConfirm.error");
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userVO.getUserId());
		
		// 아이디 중복 검사
		if (!userVO.getUserId().equals("")) {
			
			if (userService.selectUserList(map).size() > 0) {
				errors.rejectValue("userId", "userId.error");
			};
		}
		
	}

}
