package com.pythip.common.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表user实体
 * @author chemphone
 * **/
public class SecurityUserDto implements UserDetails{
	
	private static final long serialVersionUID = 2083949472555605898L;
	
	private String id;
	private String username;
	private String password;
	private String creater;
	private String status;
	private String comment;
	private Date update_time;
	private Date create_time;
	private SecurityRoleDto securityRoleDto;
	private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public void setId(String id){
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCreater(String creater){
		this.creater = creater;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public void setSecurityRoleDto(SecurityRoleDto securityRoleDto) {
		this.securityRoleDto = securityRoleDto;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public String getCreater() {
		return creater;
	}

	public String getStatus() {
		return status;
	}
	
	
	public String getComment() {
		return comment;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public SecurityRoleDto getSecurityRoleDto() {
		return securityRoleDto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.status.equals("1")? true:false;
	}
}
