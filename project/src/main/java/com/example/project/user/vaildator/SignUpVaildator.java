package com.example.project.user.vaildator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

public class SignUpVaildator implements Validator{
	
	@Resource
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO = (UserVO) target;
		
		if (!userVO.getPasswordConfirm().equals(userVO.getUserPassword())) {
			errors.rejectValue("userPassword", "passwordConfirm.error");
		}	
	}

}
