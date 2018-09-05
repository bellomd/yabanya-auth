package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.Role;
import com.yabanya.commons.orm.repository.Repository;

import java.util.Optional;

public interface RoleRepository extends Repository<Role> {

    /**
     * Find role by name
     *
     * @param roleName to find a role with
     * @return Optional Role
     */
    Optional<Role> findByRoleName(final String roleName);
}
