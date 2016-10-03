package com.pythip.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie处理
 * 
 * @author Administrator
 * 
 */
public class CookieUtil {
	public static String DEFAULT_PATH = "/";
	public static int DEFAULT_MAXAGE = 60 * 60 * 24 * 30;
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @param response
	 * @throws Exception
	 */
	public static void addCookie(String name, String value, HttpServletResponse response) throws Exception {
		Cookie cookie = new Cookie(name, Base64.encode(value));
		cookie.setPath(DEFAULT_PATH);
		cookie.setMaxAge(DEFAULT_MAXAGE);
		response.addCookie(cookie);
	}

	/**
	 * 添加Cookie
	 * 
	 * @param domain
	 * @param maxAge
	 * @param name
	 * @param value
	 * @param response
	 * @throws Exception
	 */
	public static void addCookie(String domain, int maxAge, String name, String value, HttpServletResponse response) throws Exception {
		Cookie cookie = new Cookie(name, Base64.encode(value));
		if (domain != null && !"".equals(domain.trim())) {
			cookie.setDomain(domain);
		}
		cookie.setPath(DEFAULT_PATH);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	/**
	 * 删除Cookie
	 * 
	 * @param domain
	 * @param name
	 * @param response
	 * @throws Exception
	 */
	public static void removeCookie(String name, HttpServletResponse response) throws Exception {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath(DEFAULT_PATH);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	/**
	 * 删除Cookie
	 * 
	 * @param domain
	 * @param name
	 * @param response
	 * @throws Exception
	 */
	public static void removeCookie(String domain, String name, HttpServletResponse response) throws Exception {
		Cookie cookie = new Cookie(name, null);
		cookie.setDomain(domain);
		cookie.setPath(DEFAULT_PATH);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	/**
	 * 获取Cookie
	 * 
	 * @param CookieName
	 * @param request
	 * @return
	 */
	public static String getCookieValue(String name, HttpServletRequest request) {
		String value = "";
		try {
			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(name)) {
						value = Base64.decode(cookie.getValue());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 删除所有Cookie
	 * 
	 * @param request
	 */
	public static void removeAll(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		try {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				cookie.setMaxAge(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Cookie
	 * @param cookieName 名称
	 * @return Cookie
	 */
	public static Cookie getCookie(String cookieName,HttpServletRequest request){
		/** 根据请求获取所有的Cookie */
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0){
			for (Cookie cookie : cookies){
				if (cookie.getName().equals(cookieName)){
					return cookie;
				}
			}
		}
		return null;
	}
}
