package com.yabanya.auth.api.rest;

import com.yabanya.auth.api.dto.RoleDto;
import com.yabanya.auth.api.dto.RoleUpdateDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/v1/secure/roles")
public interface RoleRestService {
	
	String CREATE_ROLE_PATH = "/v1/public/roles"; // POST
    String FIND_ROLE_BY_ID_PATH = "/v1/secure/roles/{id}"; // GET
    String UPDATE_ROLE_PATH = "/v1/secure/roles"; // PUT
    String DELETE_ROLE_PATH = "/v1/secure/roles/{id}"; // DELETE
    String ACTIVATE_ROLE_PATH = "/v1/secure/roles/{id}/activate"; // PUT
    String PASSIVATE_ROLE_PATH = "/v1/secure/roles/{id}/passivate"; // PUT
    String FIND_ROLE_BY_ROLENAME_PATH = "/v1/secure/roles/rolename/{rolename}"; // GET
	
	 /**
     * Create role rest
     *
     * @param roleDto with the details of the uroleser to create
     * @return RoleDto
     */
    @ApiOperation(
            value = CREATE_ROLE_PATH,
            notes = "Create role",
            httpMethod = "POST",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = RoleDto.class)
    RoleDto create(final RoleDto roleDto);

    /**
     * Find role with the given id
     *
     * @param id of the role to find
     * @return RoleDto found role
     */
    @ApiOperation(
            value = FIND_ROLE_BY_ID_PATH,
            notes = "Find roles",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = RoleDto.class)
    RoleDto findById(final Long id);

    /**
     * Update existing role with the given details
     *
     * @param roleDto with detail to update
     * @return RoleDto updated role
     */
    @ApiOperation(
            value = UPDATE_ROLE_PATH,
            notes = "Update role",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = RoleDto.class)
    RoleDto update(final RoleUpdateDto roleUpdateDto);

    /**
     * Delete role with the given id
     *
     * @param id of the role to delete
     */
    @ApiOperation(
            value = DELETE_ROLE_PATH,
            notes = "Delete role",
            httpMethod = "DELETE",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void delete(final Long id);

    /**
     * Activate passive or soft deleted role
     *
     * @param id of the role to activate
     * @return RoleDto activated role
     */
    @ApiOperation(
            value = ACTIVATE_ROLE_PATH,
            notes = "Activate role",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = RoleDto.class)
    RoleDto activate(final Long id);

    /**
     * Passivate active or soft deleted role
     *
     * @param id of the role to passivate
     */
    @ApiOperation(
            value = PASSIVATE_ROLE_PATH,
            notes = "Passivate role",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void passivate(final Long id);

    /**
     * Find role by name
     *
     * @param roleName to find a role with
     * @return Role
     */
    @ApiOperation(
            value = FIND_ROLE_BY_ROLENAME_PATH,
            notes = "Find role by role name",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = RoleDto.class)
    RoleDto findByRoleName(final String rolename);
}
