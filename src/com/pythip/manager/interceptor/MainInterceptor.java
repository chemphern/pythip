package com.pythip.manager.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pythip.common.constant.Constant;
import com.pythip.common.util.Base64;
import com.pythip.common.util.CookieUtil;
import com.pythip.manager.dto.User;
import com.pythip.manager.service.UserService;


/**
 * 主要的拦截器
 * 登录拦截
 * 生成随机数，防止页面资源文件缓存
 * **/
public class MainInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constant.SESSION_USER);
		if(user == null){
			Cookie cookie = CookieUtil.getCookie(Constant.COOKIES_USER,request);
			// 判断Cookie是否存在
			if (cookie != null){
				// cookie的值就是用户的id
				String userId = Base64.decode(cookie.getValue());
				// 帮助用户登录
				user = userService.getUserById(userId);
				if(user == null){
					response.sendRedirect("login.html");
				}
				// 把用户存入Session
				session.setAttribute(Constant.SESSION_USER, user);
			}else{
				response.sendRedirect("login.html");
			}
			
		}
		request.setAttribute("r_key", Math.random());
		return true;
	}

}
