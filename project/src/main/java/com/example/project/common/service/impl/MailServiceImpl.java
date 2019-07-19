package com.example.project.common.service.impl;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.project.common.service.MailService;


@Service
public class MailServiceImpl implements MailService {
	
	@Resource 
	private JavaMailSender javaMailSender;
	

	@Override
	@Async
	public void sendMail(String email, String userId, String key) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("yunyc5233@gmail.com");
			messageHelper.setSubject("계정 활성화");
			messageHelper.setTo(email);
			messageHelper.setText("http://localhost:8079/common/emailConfirm.do?userId=" + userId + "&authKey=" + key);
			javaMailSender.send(message);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
