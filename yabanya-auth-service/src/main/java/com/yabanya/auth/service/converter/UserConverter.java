package com.yabanya.auth.service.converter;

import com.yabanya.auth.api.dto.UserUpdateDto;
import com.yabanya.auth.api.dto.CreateUserDto;
import com.yabanya.auth.api.dto.UserDto;
import com.yabanya.auth.orm.entity.User;
import org.apache.commons.lang3.StringUtils;

public final class UserConverter {

    private UserConverter() {}

    public static User convert(final CreateUserDto createUserDto) {

        return  User.newBuilder(createUserDto.getUsername(), createUserDto.getPassword())
                .firstName(createUserDto.getFirstName())
                .middleName(createUserDto.getMiddleName())
                .lastName(createUserDto.getLastName())
                .phoneNumber(createUserDto.getPhoneNumber())
                .emailAddress(createUserDto.getEmailAddress())
                .contactAddress(createUserDto.getContactAddress())
                .build();
    }

    public static UserDto convert(final User user) {

        return new UserDto.UserDtoBuilder()
        		.id(user.getId())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .emailAddress(user.getEmailAddress())
                .contactAddress(user.getContactAddress())
                .build();
    }

    public static User convert(final User user, final UserUpdateDto updateUserDto) {

        if (StringUtils.isNotBlank(updateUserDto.getFirstName())) {
            user.setFirstName(updateUserDto.getFirstName());
        }

        if (StringUtils.isNotBlank(updateUserDto.getMiddleName())) {
            user.setMiddleName(updateUserDto.getMiddleName());
        }

        if (StringUtils.isNotBlank(updateUserDto.getLastName())) {
            user.setLastName(updateUserDto.getLastName());
        }

        if (StringUtils.isNotBlank(updateUserDto.getPhoneNumber())) {
            user.setPhoneNumber(updateUserDto.getPhoneNumber());
        }

        if (StringUtils.isNotBlank(updateUserDto.getEmailAddress())) {
            user.setEmailAddress(updateUserDto.getEmailAddress());
        }

        if (StringUtils.isNotBlank(updateUserDto.getContactAddress())) {
            user.setContactAddress(updateUserDto.getContactAddress());
        }

        return user;
    }
}