package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class RoleRepositoryIT extends AbstractRepositoryIT {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    public void findRole_findRoleByRoleName_optionalRole() {

        // Create role
        Role role = RoleStub.createDummyRole();
        role = roleRepository.saveAndFlush(role);

        Assert.assertNotNull(role);
        Assert.assertNotNull(role.getId());

        // Find the created role by role name
        final Optional<Role> foundRole = roleRepository.findByRoleName(role.getRoleName());

        Assert.assertTrue(foundRole.isPresent());
        Assert.assertNotNull(foundRole.get());
        Assert.assertNotNull(foundRole.get().getRoleName());
        Assert.assertEquals(role, foundRole.get());
    }
}
