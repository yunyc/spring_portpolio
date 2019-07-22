package com.example.project.main.web;

import java.util.Random;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.user.service.UserService;
import com.example.project.user.service.UserVO;

@Controller
public class MainController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/main.do")
	public String mainInit() {
		
		return "main/main";
	}
	
}
