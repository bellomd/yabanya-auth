package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.PasswordHistory;

import java.util.Random;

public final class PasswordHistoryStub {

    private PasswordHistoryStub() {}

    public static PasswordHistory creatDummyPasswordHistory() {

        return new PasswordHistory(
                new Random().nextLong(),
                DummyGenerator.dummy20CharString(),
                DummyGenerator.dummy10CharString(),
                new Random().nextLong(),
                DummyGenerator.dummyString()
        );
    }
}
