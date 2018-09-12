package com.yabanya.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yabanya.auth.api.dto.CreateUserRoleDto;
import com.yabanya.auth.api.dto.UserRoleDto;
import com.yabanya.auth.api.dto.UserRoleDtoList;
import com.yabanya.auth.api.rest.UserRoleRestService;
import com.yabanya.auth.service.UserRoleService;
import com.yabanya.auth.service.converter.UserRoleConverter;

@RestController
public class UserRoleRestServiceImpl implements UserRoleRestService {

	private final UserRoleService userRoleService;
	private final UserRoleConverter userRoleConverter;
	
	@Autowired
	public UserRoleRestServiceImpl(final UserRoleService userRoleService, final UserRoleConverter userRoleConverter) {
		this.userRoleService = userRoleService;
		this.userRoleConverter = userRoleConverter;
	}
	
	@Override
	@PostMapping(
            path = CREATE_USER_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRoleDto create(CreateUserRoleDto createUserRoleDto) {
		return UserRoleConverter.convert(userRoleService.create(userRoleConverter.convert(createUserRoleDto)));
	}

	@Override
	@GetMapping(
            path = FIND_USER_ROLE_BY_ID_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRoleDto findById(Long id) {
		return UserRoleConverter.convert(userRoleService.findById(id));
	}

	@Override
	@DeleteMapping(
            path = DELETE_USER_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void delete(Long id) {
		userRoleService.delete(id);
	}

	@Override
	@PutMapping(
            path = ACTIVATE_USER_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRoleDto activate(Long id) {
		return UserRoleConverter.convert(userRoleService.activate(id));
	}

	@Override
	@PutMapping(
            path = PASSIVATE_USER_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void passivate(Long id) {
		userRoleService.passivate(id);
	}

	@Override
	@GetMapping(
            path = FIND_USER_ROLE_BY_USER_ID_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRoleDtoList findByUserId(Long userId) {
		return new UserRoleDtoList(UserRoleConverter.convert(userRoleService.findByUserId(userId)));
	}

	@Override
	@GetMapping(
            path = FIND_USER_ROLE_BY_ROLE_ID_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRoleDtoList findByRoleId(Long roleId) {
		return new UserRoleDtoList(UserRoleConverter.convert(userRoleService.findByRoleId(roleId)));
	}
}
