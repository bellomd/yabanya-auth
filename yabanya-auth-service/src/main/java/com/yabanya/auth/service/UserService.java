package com.yabanya.auth.service;

import com.yabanya.auth.orm.entity.User;
import com.yabanya.commons.service.AbstractService;

import java.util.Optional;

public interface UserService extends AbstractService<User> {

    /**
     * Find user with the given username
     *
     * @param username to find with the given username.
     * @return User
     */
    User findByUsername(final String username);
}
