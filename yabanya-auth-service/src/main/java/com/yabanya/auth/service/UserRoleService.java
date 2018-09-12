package com.yabanya.auth.service;

import java.util.List;

import com.yabanya.auth.orm.entity.UserRole;
import com.yabanya.commons.service.AbstractService;

public interface UserRoleService extends AbstractService<UserRole> {

	/**
	 * Find user roles with the given user id
	 * 
	 * @param userId to find it roles
	 * @return List of user roles
	 */
	List<UserRole> findByUserId(final Long userId);
	
	/**
	 * Find user roles with the given role id
	 * 
	 */
	List<UserRole> findByRoleId(final Long roleId);	
}
