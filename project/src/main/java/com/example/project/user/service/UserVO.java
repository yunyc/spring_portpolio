package com.example.project.user.service;

import java.sql.Date;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

public class UserVO {
	
	/** 사용자 ID */
	@Size(min=4, max=20)
	private String userId;
	
	/** 사용자 비밀번호 */
	@Size(min=4, max=20)
	private String userPassword;
	
	/** 사용자 비밀번호 확인 */
	@NotBlank
	private String passwordConfirm;
	
	/** 사용자 이메일 앞부분 */
	@NotBlank
	private String emailPrefix;
	
	/** 사용자 이메일 뒷부분 */
	@NotBlank
	private String emailSuffix;
	
	/** 사용자 이메일 */
	private String userEmail;

	/** 사용자 인증키 */
	private int userAuthKey;
	
	/** 사용자 활성화 여부 */
	private int enabled;
	
	/** 가입 일자 */
	private Date userDate;
	
	/** 사용자 포인트 */
	private int userPoint;
	
	/** 사용자 등급 */
	private String userLevel;
	
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserAuthKey() {
		return userAuthKey;
	}
	public void setUserAuthKey(int userAuthKey) {
		this.userAuthKey = userAuthKey;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getEmailSuffix() {
		return emailSuffix;
	}
	public void setEmailSuffix(String emailSuffix) {
		this.emailSuffix = emailSuffix;
	}
	public String getEmailPrefix() {
		return emailPrefix;
	}
	public void setEmailPrefix(String emailPrefix) {
		this.emailPrefix = emailPrefix;
	}
	
	public int getAuthKey() {
		return userAuthKey;
	}
	public void setAuthKey(int authKey) {
		this.userAuthKey = authKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getUserEmail() {
		userEmail = emailPrefix + "@" + emailSuffix;
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + userPassword + ", userEmail=" + userEmail + ", userNickname="
				 + ", authKey=" + userAuthKey + ", enabled=" + enabled + ", userDate=" + userDate + "]";
	}

}
