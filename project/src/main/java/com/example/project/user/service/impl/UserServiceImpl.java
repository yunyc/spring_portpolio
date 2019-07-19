package com.example.project.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public List<UserVO> selectUserList(HashMap<String, Object> map) throws Exception {
		return userMapper.selectUserList(map);
	}

	@Override
	public void insertUserList(UserVO userVO) throws Exception {
		userMapper.insertUserList(userVO);
	}

	@Override
	public void updateAuthority(HashMap<String, Object> map) throws Exception {
		userMapper.updateAuthority(map);
		
	}

	@Override
	public void insertAuthority(UserVO userVO) throws Exception {
		userMapper.insertAuthority(userVO);
		
	}

}
