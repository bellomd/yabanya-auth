package com.yabanya.auth.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yabanya.auth.orm.entity.Role;
import com.yabanya.auth.orm.entity.User;
import com.yabanya.auth.orm.entity.UserRole;
import com.yabanya.auth.orm.repository.RoleStub;
import com.yabanya.auth.orm.repository.UserStub;
import com.yabanya.auth.service.RoleService;
import com.yabanya.auth.service.UserRoleService;
import com.yabanya.auth.service.UserService;

public class UserRoleServiceIT extends AbstractServiceIT {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Test
	@Transactional
	public void findUserRole_findUserRoleByUserId_foundUserRole() {
		
		User user = UserStub.createDummyUser();
		user = userService.create(user);
		
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
		
		Role role = RoleStub.createDummyRole();
		role = roleService.create(role);
		
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getId());
		
		UserRole userRole = new UserRole(user, role);
		userRole = userRoleService.create(userRole);
		
		Assert.assertNotNull(userRole);
		Assert.assertNotNull(userRole.getId());
		
		// Let's find the user role now using the created user id;
		 List<UserRole> userRoles = userRoleService.findByUserId(user.getId());
		 
		 Assert.assertTrue(CollectionUtils.isNotEmpty(userRoles));
		 Assert.assertEquals(1, userRoles.size());
		 Assert.assertNotNull(userRoles.get(0));
		 Assert.assertNotNull(userRoles.get(0).getId());
	}
}
