package com.yabanya.auth.service.impl;

import com.yabanya.auth.exception.UserNotFoundException;
import com.yabanya.auth.orm.entity.User;
import com.yabanya.auth.orm.repository.UserRepository;
import com.yabanya.auth.service.UserService;
import com.yabanya.commons.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserRepository> implements UserService {

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByUsername(final String username) {
        return getRepository().findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }
}
