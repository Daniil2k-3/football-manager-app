package com.example.footballmanager.exception;

public class TransferRequestException extends RuntimeException {
    public TransferRequestException(String message) {
        super(message);
    }

    public TransferRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
