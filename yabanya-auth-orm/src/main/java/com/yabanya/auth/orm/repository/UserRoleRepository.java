package com.yabanya.auth.orm.repository;

import java.util.List;

import com.yabanya.auth.orm.entity.UserRole;
import com.yabanya.commons.orm.repository.Repository;

public interface UserRoleRepository extends Repository<UserRole> {

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
