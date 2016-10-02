package com.pythip.manager.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pythip.common.constant.Constant;
import com.pythip.common.util.LoginUtil;
import com.pythip.common.util.MD5;
import com.pythip.common.vo.ResponseEx;
import com.pythip.manager.dto.User;
import com.pythip.manager.service.UserService;

@Controller
@RequestMapping("/pymanager/login")
public class LoginController {
	
	@Resource
	UserService userService;
	
	/**获取验证码**/
	@RequestMapping("getValidCode")
	public void getValidCode(HttpSession session,HttpServletResponse res) throws IOException{
		String code = LoginUtil.getRandomCode(4);
		session.setAttribute(Constant.LOGIN_VERIFY_CODE, code);
		ImageIO.write(LoginUtil.getValidCodeImage(code), "jpeg", res.getOutputStream());
	}
	
	/**登陆**/
	@RequestMapping("validation")
	@ResponseBody
	public ResponseEx validation(String username,String pwd,String val_code,HttpSession session){
		String inputError = null;
		ResponseEx ex = new ResponseEx();
		if(username ==null || "".equals(username)){
			inputError = "用户名不能为空";
		}else if(pwd == null || "".equals(pwd)){
			inputError = "密码不能为空";
		}else if(val_code == null || "".equals(val_code)){
			inputError = "验证码不能为空";
		//验证码忽略大小写相等
		}else if(session.getAttribute(Constant.LOGIN_VERIFY_CODE) == null || !((String)session.getAttribute(Constant.LOGIN_VERIFY_CODE)).equalsIgnoreCase(val_code)){
			inputError = "验证码不正确";
		}else{
			//md5加密，拼接的字符取决于security配置文件中的盐值
			pwd = MD5.getMD5ofStr(pwd + "$pythip");
			User user = userService.getUserByNameAndPwd(username, pwd);
			if(user == null){
				ex.setFail("用户名或者密码不正确");
			}else{
				session.setAttribute(Constant.SESSION_USER, user);
				ex.setSuccess("登陆成功！");
			}
		}
		if(inputError != null){
			ex.setFail(inputError);
		}
		return ex;
	}

}
