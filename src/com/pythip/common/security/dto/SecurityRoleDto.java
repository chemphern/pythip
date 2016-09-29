package com.pythip.common.security.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 角色表role实体
 * @author chemphone
 * **/
public class SecurityRoleDto implements Serializable{
	private static final long serialVersionUID = 381562460310632776L;
	private String id;
	private String role_name;
	private String role_name_en;
	private String comment;
	private Date create_time;
	private Set<SecurityAuthorityDto> authority = new HashSet<SecurityAuthorityDto>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_name_en() {
		return role_name_en;
	}
	public void setRole_name_en(String role_name_en) {
		this.role_name_en = role_name_en;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Set<SecurityAuthorityDto> getAuthority() {
		return authority;
	}
	public void setAuthority(Set<SecurityAuthorityDto> authority) {
		this.authority = authority;
	}
}
