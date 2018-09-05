package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.Role;

public final class RoleStub {

    private RoleStub() {
    }

    public static Role createDummyRole() {
        return new Role(
                DummyGenerator.dummy10CharString(),
                DummyGenerator.dummy20CharString());
    }
}
