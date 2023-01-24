package com.bolgov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends OwnException{
    public NotFoundException(String message) {
        super(message);
    }
}
