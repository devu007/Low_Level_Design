package com.lld.creational.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton pattern: ensures a class has only one instance and provides a
 * global point of access to it.
 *
 * <p>This uses the thread-safe "initialization-on-demand holder" idiom: the
 * instance is created lazily the first time {@link #getInstance()} is called,
 * and the JVM guarantees the class initialization is thread-safe.
 */
public final class AppConfig {

    private final Map<String, String> values = new HashMap<>();

    private AppConfig() {
        // private constructor prevents external instantiation
    }

    private static final class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public void set(String key, String value) {
        values.put(key, value);
    }

    public String get(String key) {
        return values.get(key);
    }
}
