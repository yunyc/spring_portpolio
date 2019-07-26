package com.example.project.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String reply() {
		return null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String replyInsert() {
		return null;
	}
		
	

}
