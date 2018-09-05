package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryIT extends AbstractRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void createUser_createNewUser_createdUser() {

        final User user = UserStub.createDummyUser();

        final User savedUser = userRepository.saveAndFlush(user);

        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser.getId());
        Assert.assertNull(savedUser.getMiddleName());
        Assert.assertNotNull(savedUser.getCreatedDate());
    }

    @Test
    @Transactional
    public void findUser_findUserByUsername_OptionalUser() {

        // Let's create a user to find first
        User user = UserStub.createDummyUser();
        user = userRepository.saveAndFlush(user);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNull(user.getMiddleName());
        Assert.assertNotNull(user.getCreatedDate());

        // Let's find the created user
        final Optional<User> foundUser = userRepository.findByUsername(user.getUsername());

        Assert.assertTrue(foundUser.isPresent());
        Assert.assertNotNull(foundUser.get());
        Assert.assertNotNull(foundUser.get().getId());
        Assert.assertNotNull(foundUser.get().getUsername());
        Assert.assertNotNull(foundUser.get().getCreatedDate());
    }

    @Test
    @Transactional
    public void findUser_findNonExistingUserByUsername_Optional() {

        // Let's find a user that doesn't exist.
        final String nonExistingUser = DummyGenerator.dummy10CharString();
        final Optional<User> foundUser = userRepository.findByUsername(nonExistingUser);

        Assert.assertFalse(foundUser.isPresent());
    }
}
