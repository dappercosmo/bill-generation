package com.trial.billGeneration.exception;

public class CustomerAlreadyPresentException extends RuntimeException {
    public CustomerAlreadyPresentException(String s, String phone) {
        super(s);
    }
}
