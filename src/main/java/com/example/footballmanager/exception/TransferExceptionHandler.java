package com.example.footballmanager.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TransferExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {TransferRequestException.class})
    public ResponseEntity<Object> handleTransferRequestException(TransferRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        TransferException transferException = new TransferException(e.getMessage(),
                e,
                badRequest,
                LocalDateTime.now());
        return new ResponseEntity<>(transferException, badRequest);
    }
}
