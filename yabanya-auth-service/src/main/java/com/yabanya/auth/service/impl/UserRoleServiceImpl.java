package com.yabanya.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yabanya.auth.orm.entity.UserRole;
import com.yabanya.auth.orm.repository.UserRoleRepository;
import com.yabanya.auth.service.UserRoleService;
import com.yabanya.commons.service.impl.AbstractServiceImpl;

@Service
public class UserRoleServiceImpl extends AbstractServiceImpl<UserRole, UserRoleRepository> implements UserRoleService {

	@Autowired
	public UserRoleServiceImpl(final UserRoleRepository userRoleRepository) {
		super(userRoleRepository);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserRole> findByUserId(Long userId) {
		return getRepository().findByUserId(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserRole> findByRoleId(Long roleId) {
		return getRepository().findByRoleId(roleId);
	}
}
