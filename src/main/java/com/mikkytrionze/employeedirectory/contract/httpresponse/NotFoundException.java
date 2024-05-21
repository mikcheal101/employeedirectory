package com.mikkytrionze.employeedirectory.contract.httpresponse;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
