package com.lld.behavioral.ChainOfResponsibility;

public class main {
    public static void main(String[] args) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObject.log(LogProcessor.ERROR, "This is an error message");
        logObject.log(LogProcessor.DEBUG, "This is a debug message");
        logObject.log(LogProcessor.INFO, "This is an info message");
    }
}
