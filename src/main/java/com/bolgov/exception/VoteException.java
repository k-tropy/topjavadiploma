package com.bolgov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VoteException extends OwnException{
    public VoteException(String message) {
        super(message);
    }
}
