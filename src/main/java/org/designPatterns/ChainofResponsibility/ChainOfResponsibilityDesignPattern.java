package org.designPatterns.ChainofResponsibility;

public class ChainOfResponsibilityDesignPattern {

    /*
    Problem Statement:
    The goal is to implement a logging system that handles different levels of logs (INFO, DEBUG, ERROR).
    Depending on the log level, different processors handle the logs, allowing us to add or remove log processors easily.

    Solution:
    We use the Chain of Responsibility Design Pattern to create a chain of log processors.
    - The `LogProcessor` abstract class represents the base log processor with common functionality.
    - Concrete processors (`InfoLogProcessor`, `ErrorLogProcessor`, `DebugLogProcessor`) handle specific log levels (INFO, ERROR, DEBUG).
    - The `log()` method passes the request along the chain of processors if the log level doesn't match the current processor's level.
    */

    // Abstract LogProcessor class that represents the base handler in the chain of responsibility
    public static abstract class LogProcessor {

        public static int INFO = 1; // Log level for informational messages
        public static int DEBUG = 2; // Log level for debugging messages
        public static int ERROR = 3; // Log level for error messages

        LogProcessor nextLoggerProcessor; // The next processor in the chain

        // Constructor initializes the next processor in the chain
        LogProcessor(LogProcessor loggerProcessor) {
            this.nextLoggerProcessor = loggerProcessor;
        }

        // Handles logging by passing the log message to the next processor if necessary
        public void log(int logLevel, String message) {
            // If there's a next processor, pass the log request to it
            if (nextLoggerProcessor != null) {
                nextLoggerProcessor.log(logLevel, message);
            }
        }
    }

    // Concrete class for processing INFO level logs
    public static class InfoLogProcessor extends LogProcessor {

        // Constructor initializes the next processor in the chain
        InfoLogProcessor(LogProcessor nexLogProcessor) {
            super(nexLogProcessor);
        }

        @Override
        // Handles the INFO level log
        public void log(int logLevel, String message) {
            if (logLevel == INFO) {
                // If the log level is INFO, process the message
                System.out.println("INFO: " + message);
            } else {
                // Otherwise, pass the message to the next processor in the chain
                super.log(logLevel, message);
            }
        }
    }

    // Concrete class for processing ERROR level logs
    public static class ErrorLogProcessor extends LogProcessor {

        // Constructor initializes the next processor in the chain
        ErrorLogProcessor(LogProcessor nexLogProcessor) {
            super(nexLogProcessor);
        }

        @Override
        // Handles the ERROR level log
        public void log(int logLevel, String message) {
            if (logLevel == ERROR) {
                // If the log level is ERROR, process the message
                System.out.println("ERROR: " + message);
            } else {
                // Otherwise, pass the message to the next processor in the chain
                super.log(logLevel, message);
            }
        }
    }

    // Concrete class for processing DEBUG level logs
    public static class DebugLogProcessor extends LogProcessor {

        // Constructor initializes the next processor in the chain
        DebugLogProcessor(LogProcessor nexLogProcessor) {
            super(nexLogProcessor);
        }

        @Override
        // Handles the DEBUG level log
        public void log(int logLevel, String message) {
            if (logLevel == DEBUG) {
                // If the log level is DEBUG, process the message
                System.out.println("DEBUG: " + message);
            } else {
                // Otherwise, pass the message to the next processor in the chain
                super.log(logLevel, message);
            }
        }
    }

    // Main method demonstrating the Chain of Responsibility pattern
    public static void main(String args[]) {

        // Create a chain of log processors: InfoLogProcessor -> DebugLogProcessor -> ErrorLogProcessor
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        // The logObject processes different log levels (ERROR, DEBUG, INFO)
        logObject.log(LogProcessor.ERROR, "exception happens"); // This will be processed by ErrorLogProcessor
        logObject.log(LogProcessor.DEBUG, "need to debug this "); // This will be processed by DebugLogProcessor
        logObject.log(LogProcessor.INFO, "just for info "); // This will be processed by InfoLogProcessor
    }
}
