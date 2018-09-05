package com.yabanya.auth.user.service;

import com.yabanya.auth.orm.entity.Role;
import com.yabanya.auth.orm.repository.RoleStub;
import com.yabanya.auth.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RoleServiceIT extends AbstractServiceIT {

    @Autowired
    private RoleService roleService;

    @Test
    @Transactional
    public void findRole_findRoleByRoleName_optionalRole() {

        // Create role
        Role role = RoleStub.createDummyRole();
        role = roleService.create(role);

        Assert.assertNotNull(role);
        Assert.assertNotNull(role.getId());

        // Find the created role by role name
        final Role foundRole = roleService.findByRoleName(role.getRoleName());

        Assert.assertNotNull(foundRole);
        Assert.assertNotNull(foundRole.getRoleName());
        Assert.assertEquals(role, foundRole);
    }
}
