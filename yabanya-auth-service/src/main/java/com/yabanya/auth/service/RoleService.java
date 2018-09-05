package com.yabanya.auth.service;

import com.yabanya.auth.orm.entity.Role;
import com.yabanya.commons.service.AbstractService;

public interface RoleService extends AbstractService<Role> {

    /**
     * Find role by name
     *
     * @param roleName to find a role with
     * @return Role
     */
    Role findByRoleName(final String roleName);
}
