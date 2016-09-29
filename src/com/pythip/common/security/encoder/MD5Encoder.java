package com.pythip.common.security.encoder;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;

import com.pythip.common.util.MD5;
/**
 * 定义Security对登陆验证时的MD5加密规则
 * @author chemphone
 * **/
public class MD5Encoder extends BasePasswordEncoder {

	public String encodePassword(String origPwd, Object salt) throws DataAccessException {
		String saltStr = (String)salt;
		return MD5.getMD5ofStr(origPwd+saltStr);
	}

	public boolean isPasswordValid(String encPwd, String origPwd, Object salt) throws DataAccessException {
		return encPwd.equals(encodePassword(origPwd, salt));
	}

}
