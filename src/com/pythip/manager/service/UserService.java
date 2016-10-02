package com.pythip.manager.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pythip.common.annotation.Mybatis;
import com.pythip.common.service.BaseService;
import com.pythip.manager.dto.User;

/**
 * 用户服务
 * **/
@Mybatis(namespace = "com.pythip.manager.mapper.UserMapper")
@Service
public class UserService extends BaseService{
	/**根据用户名密码获取用户信息**/
	public User getUserByNameAndPwd(String username,String pwd){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("username", username);
		param.put("password", pwd);
		return selectOne("getUserByNameAndPwd",param);
	}

}
