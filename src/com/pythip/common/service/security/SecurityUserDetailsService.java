package com.pythip.common.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pythip.common.annotation.Mybatis;
import com.pythip.common.security.dto.SecurityRoleDto;
import com.pythip.common.security.dto.SecurityUserDto;
import com.pythip.common.service.BaseService;

/**
 * 加载当前用户信息。提交到security，让其验证该用户密码是否正确，并将该用户信息放取到别处。
 * @author chemphone
 * **/
@Mybatis(namespace = "com.pythip.common.mapper.SecurityUserDetailsMapper")
@Service
public class SecurityUserDetailsService extends BaseService implements IsecurityUserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String loginUsername) throws UsernameNotFoundException {
		SecurityUserDto user = selectOne("loadUserByUsername", loginUsername);
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		SecurityRoleDto role = selectOne("loadRoleByUserid",user.getId());
		//单角色
		authSet.add(new GrantedAuthorityImpl(role.getRole_name_en()));
		Collection<GrantedAuthority> collection = authSet;
		user.setAuthorities(collection);
		return user;
	}

}
