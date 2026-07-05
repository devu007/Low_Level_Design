package com.lld;

import com.lld.creational.singleton.AppConfig;

/**
 * Entry point for quickly running/experimenting with patterns.
 *
 * Run it with:  mvn -q compile exec:java
 * Or click the "Run" button above the main method in Cursor.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("LLD playground is set up and running.\n");

        // Demo: Singleton pattern
        AppConfig config = AppConfig.getInstance();
        config.set("env", "learning");
        System.out.println("Singleton demo -> env = " + AppConfig.getInstance().get("env"));
    }
}
