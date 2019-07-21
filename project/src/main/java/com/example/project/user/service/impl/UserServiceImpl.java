package com.example.project.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

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

}
