package com.lld.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class AppConfigTest {

    @Test
    void returnsSameInstance() {
        AppConfig first = AppConfig.getInstance();
        AppConfig second = AppConfig.getInstance();
        assertSame(first, second, "Singleton must always return the same instance");
    }

    @Test
    void sharesStateAcrossReferences() {
        AppConfig.getInstance().set("key", "value");
        assertEquals("value", AppConfig.getInstance().get("key"));
    }
}
