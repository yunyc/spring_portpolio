package com.example.project.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource 
	private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public List<UserVO> selectUserList(HashMap<String, Object> map) throws Exception {
		return userMapper.selectUserList(map);
	}

	@Override
	@Transactional
	public void insertUserList(UserVO userVO) throws Exception {
		userMapper.insertUserList(userVO);
	}

	@Override
	@Transactional
	public void updateAuthority(HashMap<String, Object> map) throws Exception {
		userMapper.updateAuthority(map);
		
	}

	@Override
	@Transactional
	public void insertAuthority(UserVO userVO) throws Exception {
		userMapper.insertAuthority(userVO);	
	}
	
	@Override
	@Async
	public void sendAuthKey(String email, String userId, int key) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("yunyc5233@gmail.com");
			messageHelper.setSubject("계정 활성화");
			messageHelper.setTo(email);
			messageHelper.setText("http://localhost:8079/emailConfirm?userId=" + userId + "&authKey=" + key);
			javaMailSender.send(message);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Async
	public void sendUserInfo(String email, String userId, String userPassword) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("yunyc5233@gmail.com");
			messageHelper.setSubject("아이디와 비밀번호");
			messageHelper.setTo(email);
			messageHelper.setText("아이디:" + userId + "\n" + "비밀번호:" + userPassword);
			javaMailSender.send(message);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
