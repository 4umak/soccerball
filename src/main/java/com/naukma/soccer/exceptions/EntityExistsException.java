package com.naukma.soccer.exceptions;

public class EntityExistsException extends ValidationSoccerException {
    public EntityExistsException(String message) {
        super(message);
    }
}
