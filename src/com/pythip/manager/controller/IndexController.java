package com.pythip.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pymanager")
public class IndexController{
	@RequestMapping("/login")
	public String login(){
		return "/manager/login";
	}
	@RequestMapping("/index")
	public String index(){
		return "/manager/index/index";
	}
}
