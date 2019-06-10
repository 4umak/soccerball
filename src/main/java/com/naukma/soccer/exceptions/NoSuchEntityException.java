package com.naukma.soccer.exceptions;

public class NoSuchEntityException extends ValidationSoccerException {
    public NoSuchEntityException(final String message) {
        super(message);
    }
}

