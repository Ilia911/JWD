package com.epam.jwd.model.exception;

public class TooShortPointArrayException extends Exception {
    public TooShortPointArrayException() {
        super();
    }
    public TooShortPointArrayException(Exception e) {
        super(e);
    }
    public TooShortPointArrayException(String message) {
        super(message);
    }
    public TooShortPointArrayException(String message, Exception e) {
        super(message, e);
    }

}
