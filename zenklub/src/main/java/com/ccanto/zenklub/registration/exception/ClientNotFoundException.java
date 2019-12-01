package com.ccanto.zenklub.registration.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException() {
        super();
    }

    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
