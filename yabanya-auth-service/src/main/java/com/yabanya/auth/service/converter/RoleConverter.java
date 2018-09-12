package com.yabanya.auth.service.converter;

import org.apache.commons.lang3.StringUtils;

import com.yabanya.auth.api.dto.CreateRoleDto;
import com.yabanya.auth.api.dto.RoleDto;
import com.yabanya.auth.api.dto.RoleUpdateDto;
import com.yabanya.auth.orm.entity.Role;

public final class RoleConverter {

	private RoleConverter() {}
	
	public static Role convert(final CreateRoleDto createRoleDto) {
		return new Role(createRoleDto.getRoleName(), createRoleDto.getRoleDescription());
	}
	
	public static RoleDto convert(final Role role) {
		
		final RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setRoleName(role.getRoleName());
		roleDto.setRoleDescription(role.getRoleDescription());
		
		return roleDto;
	}
	
	public static Role convert(final Role role, final RoleUpdateDto roleUpdateDto) {
		
		if (StringUtils.isNotBlank(roleUpdateDto.getRoleName())) {
			role.setRoleName(roleUpdateDto.getRoleName());
		}
		
		if (StringUtils.isNotBlank(roleUpdateDto.getRoleDescription())) {
			role.setRoleDescription(roleUpdateDto.getRoleDescription());
		}
		
		return role;
	}
}
