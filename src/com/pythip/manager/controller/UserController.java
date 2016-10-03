package com.pythip.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pymanager/user")
public class UserController {
	@RequestMapping("mgt")
	public String home(){
		return "/manager/user/mgt";
	}
}
