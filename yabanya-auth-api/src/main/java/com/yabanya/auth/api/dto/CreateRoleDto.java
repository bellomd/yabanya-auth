package com.yabanya.auth.api.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@XmlRootElement(name = "createRoleDto")
@ApiModel(value = "CreateRoleDto")
public class CreateRoleDto implements Serializable {

	private static final long serialVersionUID = -2150351800309404204L;

	private String roleName;
	private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
