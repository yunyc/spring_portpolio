package com.example.project.common.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.common.service.MailService;
import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Controller
public class MailController {
	
	@Resource
	private MailService mailService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/common/emailConfirm.do")
	public String emailConfirm(@RequestParam HashMap<String, Object> map) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(map);
		
		System.out.println(map);
		
		if (userList == null) {
			
			return "main/main";
			
		} else {
			userService.updateAuthority(map);
			return "main/main";
		}
		
		
	}

}
