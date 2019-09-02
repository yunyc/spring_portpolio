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

/**
 * @Class Name : UserServiceImpl.java
 * @Description : UserServiceImpl Class
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

@Service
public class UserServiceImpl implements UserService {
	
	/** UserMapper 인터페이스 */
	@Resource
	private UserMapper userMapper;
	
	/** JavaMailSender */
	@Resource 
	private JavaMailSender javaMailSender;
	
	/**
	 * 사용자 조회
	 * @param map - 사용자 옵션 HashMap
	 * @return "List<UserVO>"
	 * @exception Exception
	 */
	@Override
	public List<UserVO> selectUserList(HashMap<String, Object> map) {
		return userMapper.selectUserList(map);
	}
	
	/**
	 * 사용자 등록
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void insertUserList(UserVO userVO) throws Exception {
		userMapper.insertUserList(userVO);
	}
	
	/**
	 * 사용자 권한 추가
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void updateAuthority(HashMap<String, Object> map) throws Exception {
		userMapper.updateAuthority(map);
		
	}
	
	/**
	 * 사용자 권한 수정
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	public void insertAuthority(UserVO userVO) throws Exception {
		userMapper.insertAuthority(userVO);	
	}
	
	/**
	 * 사용자 인증키 메일 보내기
	 * @param email - 사용자 이메일
	 * @param userId - 사용자 ID
	 * @param key - 인증키
	 * @return "void"
	 * @exception Exception
	 */
	@Override
	@Async
	public void sendAuthKey(String email, String userId, int key) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom("yunyc5233@gmail.com");
			messageHelper.setSubject("계정 활성화");
			messageHelper.setTo(email);
			messageHelper.setText("http://localhost:8079/emailConfirm?userId=" + userId + "&userAuthKey=" + key);
			javaMailSender.send(message);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 사용자 정보 메일로 보내기
	 * @param email - 사용자 이메일
	 * @param userId - 사용자 ID
	 * @param userPassword - 사용자 비밀번호
	 * @return "void"
	 * @exception Exception
	 */
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
	
	/**
	 * 인증기 n자리 생성
	 * @param email - 사용자 이메일
	 * @return authKey
	 * @exception Exception
	 */
	@Override
	public int getAuthKey(int num) {
		
		int max = (int) Math.pow(10, num);
		int min = (int) Math.pow(10, (num - 1));
		int authKey = (int) Math.floor(Math.random() * max) + min;
		
		if(authKey > max){
			authKey -= min;
		} 
		return authKey;
	}

}
