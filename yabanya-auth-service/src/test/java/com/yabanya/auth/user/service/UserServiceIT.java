package com.yabanya.auth.user.service;

import com.yabanya.auth.exception.UserNotFoundException;
import com.yabanya.auth.orm.entity.User;
import com.yabanya.auth.orm.repository.DummyGenerator;
import com.yabanya.auth.orm.repository.UserStub;
import com.yabanya.auth.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceIT extends AbstractServiceIT{

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void createUser_createNewUser_createdUser() {

        final User user = UserStub.createDummyUser();

        final User savedUser = userService.create(user);

        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser.getId());
        Assert.assertNull(savedUser.getMiddleName());
        Assert.assertNotNull(savedUser.getCreatedDate());
    }

    @Test
    @Transactional
    public void findUser_findUserByUsername_returnFoundUser() {

        // Let's create a user to find later
        User user = UserStub.createDummyUser();
        user = userService.create(user);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNull(user.getMiddleName());
        Assert.assertNotNull(user.getCreatedDate());

        // Let's find an existing user
        final User foundUser = userService.findByUsername(user.getUsername());

        Assert.assertNotNull(foundUser);
        Assert.assertNotNull(foundUser.getCreatedBy());
        Assert.assertNotNull(foundUser.getCreatedDate());
        Assert.assertEquals(user.getUsername(), foundUser.getUsername());
    }

    @Test(expected = UserNotFoundException.class)
    @Transactional
    public void findUser_findNonExistingUserByUsername_ThrowsUserNotFoundException() {

        // Let's find a user that doesn't exist.
        final String nonExistingUser = DummyGenerator.dummy10CharString();
        userService.findByUsername(nonExistingUser);
    }
}
