package com.kai.async.exception;

public class SkippedException extends RuntimeException{

    public SkippedException() {
        super();
    }

    public SkippedException(String message) {
        super(message);
    }
}