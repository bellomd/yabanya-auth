package com.yabanya.auth.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@XmlRootElement(name = "userRoleDtoList")
@ApiModel(value = "UserRoleDtoList")
public class UserRoleDtoList implements Serializable {

	private static final long serialVersionUID = -3048343721017385516L;
	
	@XmlElement(name = "userRoleDto")
	private List<UserRoleDto> userRoleDtoList;
	
	public UserRoleDtoList(final List<UserRoleDto> userRoleDtoList) {
		this.userRoleDtoList = userRoleDtoList;
	}

	public List<UserRoleDto> getUserRoleDtoList() {
		return userRoleDtoList;
	}

	public void setUserRoleDtoList(List<UserRoleDto> userRoleDtoList) {
		this.userRoleDtoList = userRoleDtoList;
	}

	public void addUserRoleDto(final UserRoleDto userRoleDto) {
		if (userRoleDtoList == null) {
			userRoleDtoList = new ArrayList<UserRoleDto>();
		}
		userRoleDtoList.add(userRoleDto);
	}
}
