package com.pythip.common.security.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限表authority实体
 * @author chemphone
 * **/
public class SecurityAuthorityDto implements Serializable{
	private static final long serialVersionUID = 1729990589692177615L;
	private String id;
	private String authority_name;
	private String url;
	private Date last_operator_time;
	private String parent_id;
	private String comment;
	private Date create_time;
	private Integer checkState = 0;
	private Boolean isExpand = false;
	private SecurityAuthorityDto parentAuthority;
	private Set<SecurityAuthorityDto> childrenAuthority = new HashSet<SecurityAuthorityDto>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getLast_operator_time() {
		return last_operator_time;
	}
	public void setLast_operator_time(Date last_operator_time) {
		this.last_operator_time = last_operator_time;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
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
	public SecurityAuthorityDto getParentAuthority() {
		return parentAuthority;
	}
	public void setParentAuthority(SecurityAuthorityDto parentAuthority) {
		this.parentAuthority = parentAuthority;
	}
	public Set<SecurityAuthorityDto> getChildrenAuthority() {
		return childrenAuthority;
	}
	public void setChildrenAuthority(Set<SecurityAuthorityDto> childrenAuthority) {
		this.childrenAuthority = childrenAuthority;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public Boolean getIsExpand() {
		return isExpand;
	}
	public void setIsExpand(Boolean isExpand) {
		this.isExpand = isExpand;
	}
}
