package com.example.project.user.vaildator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.user.service.UserVO;

public class SignUpVaildator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO = (UserVO) target;
		
		if (!userVO.getPasswordConfirm().equals(userVO.getUserPassword())) {
			errors.rejectValue("userPassword", "error");
		}
		
	}

}
