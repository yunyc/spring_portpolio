package com.example.project.user.service;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserVO {
	
	@Size(min=1, max=20, message = "아이디는 1~20자 영문,숫자이어야 합니다")
	private String userId;
	
	@Size(min=1, max=10, message = "비밀번호는 1~20자 영문이어야 합니다")
	private String userPassword;
	
	private String passwordConfirm;
	
	private String emailPrefix;
	
	private String emailSuffix;
	
	private String userEmail;
	
	@Size(min=1, max=10, message = "오류가 났습니다")
	private String userNickname;
	private int userAuthKey;
	private int enabled;
	private Date userDate;
	
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
	public String getPassword() {
		return userPassword;
	}
	public void setPassword(String password) {
		this.userPassword = password;
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
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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
				+ userNickname + ", authKey=" + userAuthKey + ", enabled=" + enabled + ", userDate=" + userDate + "]";
	}

}
