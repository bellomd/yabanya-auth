package com.yabanya.auth.orm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yabanya.auth.orm.entity.Role;
import com.yabanya.auth.orm.entity.User;
import com.yabanya.auth.orm.entity.UserRole;

public class UserRoleRepositoryIT extends AbstractRepositoryIT {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	@Transactional
	public void findUserRole_findUserRoleByUserId_foundUserRole() {
		
		User user = UserStub.createDummyUser();
		user = userRepository.saveAndFlush(user);
		
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
		
		Role role = RoleStub.createDummyRole();
		role = roleRepository.saveAndFlush(role);
		
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getId());
		
		UserRole userRole = new UserRole(user, role);
		userRole = userRoleRepository.saveAndFlush(userRole);
		
		Assert.assertNotNull(userRole);
		Assert.assertNotNull(userRole.getId());
		
		// Let's find the user role now using the created user id;
		 List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());
		 
		 Assert.assertTrue(CollectionUtils.isNotEmpty(userRoles));
		 Assert.assertEquals(1, userRoles.size());
		 Assert.assertNotNull(userRoles.get(0));
		 Assert.assertNotNull(userRoles.get(0).getId());
	}
}
