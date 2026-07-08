package com.lld.behavioral.ChainOfResponsibility;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor next) {
        super(next);
    }

    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("Info: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
