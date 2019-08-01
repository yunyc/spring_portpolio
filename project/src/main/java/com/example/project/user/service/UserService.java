package com.example.project.user.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {
	
	List<UserVO> selectUserList(HashMap<String, Object> map) throws Exception;
	
	void insertUserList(UserVO userVO) throws Exception;
	
	void insertAuthority(UserVO userVO) throws Exception;
	
	void updateAuthority(HashMap<String, Object> map) throws Exception;
	
	// 메일
	
	void sendAuthKey(String email, String userId, int key);
	
	void sendUserInfo(String email, String userId, String userPassword);

}
