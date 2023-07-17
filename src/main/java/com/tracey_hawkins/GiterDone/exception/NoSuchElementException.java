package com.tracey_hawkins.GiterDone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementException extends RuntimeException{
    private static final Long serialVersionUID = 1L;
    public NoSuchElementException(String message){
        super(message);
    }
}
