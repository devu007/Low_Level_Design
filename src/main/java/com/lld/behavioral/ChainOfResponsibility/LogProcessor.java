package com.lld.behavioral.ChainOfResponsibility;

public class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor next;
    LogProcessor(LogProcessor next) {
        this.next = next;
    }
    
    public void log(int logLevel, String message) {
        if (next != null) {
            next.log(logLevel, message);
        }
    }   
}
