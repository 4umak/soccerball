package com.naukma.soccer.exceptions;


public abstract class ValidationSoccerException extends IllegalArgumentException {
    public ValidationSoccerException(final String message) {
        super(message);
    }
}
