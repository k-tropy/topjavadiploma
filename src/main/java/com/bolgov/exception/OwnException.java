package com.bolgov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class OwnException extends RuntimeException{
    public OwnException(String message) {
        super(message);
    }

}
