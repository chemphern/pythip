package com.pythip.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 主要的拦截器
 * 登录拦截
 * 生成随机数，防止页面资源文件缓存
 * **/
public class MainInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("r_key", Math.random());
		return true;
	}

}
