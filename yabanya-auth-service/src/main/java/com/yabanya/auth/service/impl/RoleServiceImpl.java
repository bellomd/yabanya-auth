package com.yabanya.auth.service.impl;

import com.yabanya.auth.exception.RoleNotFoundException;
import com.yabanya.auth.orm.entity.Role;
import com.yabanya.auth.orm.repository.RoleRepository;
import com.yabanya.auth.service.RoleService;
import com.yabanya.commons.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role, RoleRepository> implements RoleService {

    @Autowired
    public RoleServiceImpl(final RoleRepository roleRepository) {
        super(roleRepository);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Role findByRoleName(final String roleName) {
        return getRepository().findByRoleName(roleName).orElseThrow(() ->
                new RoleNotFoundException("Role not found with roleName: " + roleName));
    }
}
