package com.yabanya.auth.api.rest;

import com.yabanya.auth.api.dto.UpdateUserDto;
import com.yabanya.auth.api.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/v1/secure/users/")
public interface UserRestService {

    String CREATE_USER_PATH = "/v1/public/users"; // POST
    String FIND_USER_BY_ID_PATH = "/v1/secure/users/{id}"; // GET
    String UPDATE_USER_PATH = "/v1/secure/users"; // PUT
    String DELETE_USER_PATH = "/v1/secure/users/{id}"; // DELETE
    String ACTIVATE_USER_PATH = "/v1/secure/users/{id}/activate"; // PUT
    String PASSIVATE_USER_PATH = "/v1/secure/users/{id}/passivate"; // PUT
    String FIND_USER_BY_USERNAME_PATH = "/v1/secure/users/username/{username}"; // GET


    /**
     * Create user rest
     *
     * @param userDto with the details of the user to create
     * @return UserDto
     */
    @ApiOperation(
            value = "/v1/public/users",
            notes = "Create user",
            httpMethod = "POST",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserDto.class)
    UserDto create(final UserDto userDto);

    /**
     * Find user with the given id
     *
     * @param id of the user to find
     * @return UserDto found user
     */
    @ApiOperation(
            value = "/v1/secure/users/{id}",
            notes = "Find user",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserDto.class)
    UserDto findById(final Long id);

    /**
     * Update existing user with the given details
     *
     * @param updateUserDto with detail to update
     * @return UserDto updated user
     */
    @ApiOperation(
            value = "/v1/secure/users",
            notes = "Update user",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserDto.class)
    UserDto update(final UpdateUserDto updateUserDto);

    /**
     * Delete user with the given id
     *
     * @param id of the user to delete
     */
    @ApiOperation(
            value = "/v1/secure/users/{id}",
            notes = "Delete user",
            httpMethod = "DELETE",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void delete(final Long id);

    /**
     * Activate passivated or soft deleted user
     *
     * @param id of the user to activate
     * @return UserDto updated user
     */
    @ApiOperation(
            value = "/v1/secure/users/{id}/activate",
            notes = "Activate user",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserDto.class)
    UserDto activate(final Long id);

    /**
     * Passivate active or soft deleted user
     *
     * @param id of the user to passivate
     */
    @ApiOperation(
            value = "/v1/secure/users/{id}/passivate",
            notes = "Passivate user",
            httpMethod = "PUT",
            consumes = "application/json application/xml",
            produces = "application/json application/xml")
    void passivate(final Long id);

    /**
     * Find user with given username
     *
     * @param username of the user to find
     * @return UserDto found user.
     */
    @ApiOperation(
            value = "/v1/secure/users/username/{username}",
            notes = "Find user by username",
            httpMethod = "GET",
            consumes = "application/json application/xml",
            produces = "application/json application/xml",
            response = UserDto.class)
    UserDto findByUsername(final String username);
}
