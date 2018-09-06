package com.yabanya.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yabanya.auth.api.dto.RoleDto;
import com.yabanya.auth.api.dto.RoleUpdateDto;
import com.yabanya.auth.api.rest.RoleRestService;
import com.yabanya.auth.orm.entity.Role;
import com.yabanya.auth.service.RoleService;
import com.yabanya.auth.service.converter.RoleConverter;

@RestController
public class RoleRestServiceImpl implements RoleRestService {

	private final RoleService roleService;
	
	@Autowired
	public RoleRestServiceImpl(final RoleService roleService) {
		this.roleService = roleService;
	}
	
	@Override
    @PostMapping(
            path = CREATE_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RoleDto create(RoleDto roleDto) {
		return RoleConverter.convert(roleService.create(RoleConverter.convert(roleDto)));
	}

	@Override
	@PostMapping(
            path = FIND_ROLE_BY_ID_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RoleDto findById(Long id) {
		return RoleConverter.convert(roleService.findById(id));
	}

	@Override
	@PostMapping(
            path = UPDATE_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RoleDto update(RoleUpdateDto roleUpdateDto) {
		
		final Role role = roleService.findById(roleUpdateDto.getRoleId());
		return RoleConverter.convert(roleService.update(RoleConverter.convert(role, roleUpdateDto)));
	}
              
	@Override
	@PostMapping(
            path = DELETE_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void delete(Long id) {
		roleService.delete(id);
	}

	@Override
	@PostMapping(
            path = ACTIVATE_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RoleDto activate(Long id) {
		return RoleConverter.convert(roleService.activate(id));
	}

	@Override
	@PostMapping(
            path = PASSIVATE_ROLE_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void passivate(Long id) {
		roleService.passivate(id);
	}

	@Override
	@PostMapping(
            path = FIND_ROLE_BY_ROLENAME_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RoleDto findByRoleName(final String rolename) {
		return RoleConverter.convert(roleService.findByRoleName(rolename));
	}
}
