package com.yabanya.auth.api.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@XmlRootElement(name = "createUserRoleDto")
@ApiModel(value = "CreateUserRoleDto")
public class CreateUserRoleDto implements Serializable {

	private static final long serialVersionUID = 598025631752297077L;
	
	private Long userId;
	private Long roleId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
