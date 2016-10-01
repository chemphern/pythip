package com.pythip.manager.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pythip.common.constant.Constant;
import com.pythip.common.util.LoginUtil;

@Controller
@RequestMapping("/pymanager/login")
public class LoginController {
	
	/**获取验证码**/
	@RequestMapping("getValidCode")
	public void getValidCode(HttpSession session,HttpServletResponse res) throws IOException{
		String code = LoginUtil.getRandomCode(4);
		session.setAttribute(Constant.LOGIN_VERIFY_CODE, code);
		ImageIO.write(LoginUtil.getValidCodeImage(code), "jpeg", res.getOutputStream());
	}

}
