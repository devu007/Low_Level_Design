package com.lld.behavioral.ChainOfResponsibility;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor next) {
        super(next);
    }
    
    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("Debug: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
