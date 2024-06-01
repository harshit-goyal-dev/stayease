package com.harshit.stayease.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyRegisteredException extends RuntimeException{

    public UserAlreadyRegisteredException(String message){
        super(message);
    }
}
