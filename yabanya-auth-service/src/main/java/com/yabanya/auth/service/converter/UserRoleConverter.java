package com.yabanya.auth.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yabanya.auth.api.dto.CreateUserRoleDto;
import com.yabanya.auth.api.dto.UserRoleDto;
import com.yabanya.auth.orm.entity.UserRole;
import com.yabanya.auth.service.RoleService;
import com.yabanya.auth.service.UserService;

@Component
public class UserRoleConverter {
	
	private final UserService userService;
	private final RoleService roleService;
	
	@Autowired
	public UserRoleConverter(final UserService userService, final RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	public UserRole convert(final CreateUserRoleDto createUserRoleDto) {
		return new UserRole(userService.findById(createUserRoleDto.getUserId()), 
				roleService.findById(createUserRoleDto.getRoleId()));
	}
	
	public static UserRoleDto convert(final UserRole userRole) {
		
		final UserRoleDto userRoleDto =  new UserRoleDto();
		userRoleDto.setId(userRole.getId());
		userRoleDto.setUserId(userRole.getUser().getId());
		userRoleDto.setRoleId(userRole.getRole().getId());
		
		return userRoleDto;
	}
	
	public static List<UserRoleDto> convert(final List<UserRole> userRoles) {
		return userRoles.stream().map(userRole -> UserRoleConverter.convert(userRole)).collect(Collectors.toList());
	}
}
