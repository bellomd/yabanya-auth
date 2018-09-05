package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.User;
import com.yabanya.commons.orm.repository.Repository;

import java.util.Optional;

/**
 * DAO operations for User entity
 */
public interface UserRepository extends Repository<User> {

    /**
     * Find user with the given username
     *
     * @param username to find with the given username.
     * @return Optional user
     */
    Optional<User> findByUsername(final String username);
}
