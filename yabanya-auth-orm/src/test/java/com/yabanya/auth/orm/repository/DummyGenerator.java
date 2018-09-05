package com.yabanya.auth.orm.repository;

import java.util.Random;
import java.util.UUID;

public final class DummyGenerator {

    private DummyGenerator() {}

    public static String dummy10CharString() {
        return UUID.randomUUID().toString().substring(0, 9);
    }

    public static String dummy20CharString() {
        return UUID.randomUUID().toString().substring(0, 19);
    }

    public static String dummyEmailAddress() {
        final String str = UUID.randomUUID().toString().substring(0, 9);
        return str + "@" + "yabanya.com";
    }

    public static String dummyString() {
        return UUID.randomUUID().toString();
    }

    public static long randomLong() {
        return new Random().nextLong();
    }
}
