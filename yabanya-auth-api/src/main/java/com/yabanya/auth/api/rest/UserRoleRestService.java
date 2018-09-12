package com.yabanya.auth.api.rest;

import java.util.List;

import com.yabanya.auth.api.dto.CreateUserRoleDto;
import com.yabanya.auth.api.dto.UserRoleDto;
import com.yabanya.auth.api.dto.UserRoleDtoList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/v1/secure/userroles/")
public interface UserRoleRestService {
	
	String CREATE_USER_ROLE_PATH = "/v1/public/userroles"; // POST
    String FIND_USER_ROLE_BY_ID_PATH = "/v1/secure/userroles/{id}"; // GET
    //String UPDATE_USERROLE_PATH = "/v1/secure/userroles"; // PUT
    String DELETE_USER_ROLE_PATH = "/v1/secure/userroles/{id}"; // DELETE
    String ACTIVATE_USER_ROLE_PATH = "/v1/secure/userroles/{id}/activate"; // PUT
    String PASSIVATE_USER_ROLE_PATH = "/v1/secure/userroles/{id}/passivate"; // PUT
    //String FIND_USER_ROLE_BY_USERNAME_PATH = "/v1/secure/userroles/username/{username}"; // GET
    String FIND_USER_ROLE_BY_USER_ID_PATH = "/v1/secure/userroles/users/{userId}";
    String FIND_USER_ROLE_BY_ROLE_ID_PATH = "/v1/secure/userroles/roles/{roleId}";


    /**
     * Create user role service
     *
     * @param createUserRoleDto with the details of the user role to create
     * @return UserRoleDto
     */
    @ApiOperation(
            value = CREATE_USER_ROLE_PATH,
            notes = "Create user role",
            httpMethod = "POST",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserRoleDto.class)
    UserRoleDto create(final CreateUserRoleDto createUserRoleDto);

    /**
     * Find user role with the given id
     *
     * @param id of the user role to find
     * @return UserRoleDto found user role
     */
    @ApiOperation(
            value = FIND_USER_ROLE_BY_ID_PATH,
            notes = "Find user role",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserRoleDto.class)
    UserRoleDto findById(final Long id);

    /**
     * Delete user role with the given id
     *
     * @param id of the user role to delete
     */
    @ApiOperation(
            value = DELETE_USER_ROLE_PATH,
            notes = "Delete user role",
            httpMethod = "DELETE",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void delete(final Long id);

    /**
     * Activate passive or soft deleted user role
     *
     * @param id of the user role to activate
     * @return UserRoleDto updated user role
     */
    @ApiOperation(
            value = ACTIVATE_USER_ROLE_PATH,
            notes = "Activate user role",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserRoleDto.class)
    UserRoleDto activate(final Long id);

    /**
     * Passivate active or soft deleted user role
     *
     * @param id of the user role to passivate
     */
    @ApiOperation(
            value = PASSIVATE_USER_ROLE_PATH,
            notes = "Passivate user role",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void passivate(final Long id);

	/**
	 * Find user roles with the given user id
	 * 
	 * @param userId to find it roles
	 * @return List of UserRoleDto
	 */
    @ApiOperation(
            value = FIND_USER_ROLE_BY_USER_ID_PATH,
            notes = "Find user role by user id",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = List.class)
    UserRoleDtoList findByUserId(final Long userId);
	
	/**
	 * Find user roles with the given role id
	 * 
	 * @param roleId to find the user role with.
	 * @return List of UserRoleDto
	 */
    @ApiOperation(
            value = FIND_USER_ROLE_BY_ROLE_ID_PATH,
            notes = "Find user role by role id",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = List.class)
    UserRoleDtoList findByRoleId(final Long roleId);	
}
