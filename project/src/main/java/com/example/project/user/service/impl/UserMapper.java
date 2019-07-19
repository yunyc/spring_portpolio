package com.example.project.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.user.service.UserVO;

@Mapper
public interface UserMapper {
	
	List<UserVO> selectUserList(HashMap<String, Object> map) throws Exception;
	
	void insertUserList(UserVO userVO) throws Exception;
	
	void insertAuthority(UserVO userVO) throws Exception;
	
	void updateAuthority(HashMap<String, Object> map) throws Exception;

}
