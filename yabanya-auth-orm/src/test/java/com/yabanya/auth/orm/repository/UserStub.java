package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.User;

import java.util.Random;
import java.util.UUID;

public final class UserStub {

    private UserStub() {
    }

    public static User createDummyUser() {

        final String firstName = DummyGenerator.dummy20CharString();
        final String lastName = DummyGenerator.dummy20CharString();
        final String userName = DummyGenerator.dummy20CharString();
        final String password = DummyGenerator.dummy20CharString();
        final String phoneNumber = DummyGenerator.dummy10CharString();
        final String emailAddress = DummyGenerator.dummyEmailAddress();
        final String contactAddress = DummyGenerator.dummyString();

        return User.newBuilder(userName, password)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .emailAddress(emailAddress)
                .contactAddress(contactAddress)
                .build();
    }
}
