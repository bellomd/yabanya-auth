package com.yabanya.auth.web.controller;

import com.yabanya.auth.api.dto.UpdateUserDto;
import com.yabanya.auth.api.dto.UserDto;
import com.yabanya.auth.api.rest.UserRestService;
import com.yabanya.auth.orm.entity.User;
import com.yabanya.auth.exception.UserNotFoundException;
import com.yabanya.auth.service.UserService;
import com.yabanya.auth.service.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserRestServiceImpl implements UserRestService {

    private final UserService userService;

    @Autowired
    public UserRestServiceImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping(
            path = CREATE_USER_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDto create(@Valid @RequestBody final UserDto userDto) {
        return UserConverter.convert(userService.create(UserConverter.convert(userDto)));
    }

    @Override
    @GetMapping(
            path = FIND_USER_BY_ID_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDto findById(@NotNull @PathVariable final Long id) {
        return UserConverter.convert(userService.findById(id));
    }

    @Override
    @PutMapping(
            path = UPDATE_USER_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDto update(@Valid @RequestBody final UpdateUserDto updateUserDto) {
        final User user = userService.findById(updateUserDto.getId());
        return UserConverter.convert(userService.update(UserConverter.convert(user, updateUserDto)));
    }

    @Override
    @DeleteMapping(
            path = DELETE_USER_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void delete(@NotNull @PathVariable final Long id) {
        userService.deleteSoftly(id);
    }

    @Override
    @PutMapping(
            path = ACTIVATE_USER_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDto activate(@NotNull @PathVariable final Long id) {
        return UserConverter.convert(userService.activate(id));
    }

    @Override
    @PutMapping(
            path = PASSIVATE_USER_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void passivate(@NotNull @PathVariable final Long id) {
        userService.passivate(id);
    }

    @Override
    @GetMapping(
            path = FIND_USER_BY_USERNAME_PATH,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDto findByUsername(@NotNull @PathVariable final String username) {
        return UserConverter.convert(userService.findByUsername(username));
    }
}
