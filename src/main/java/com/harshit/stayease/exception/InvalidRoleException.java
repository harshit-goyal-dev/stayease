package com.harshit.stayease.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidRoleException extends RuntimeException{

    public InvalidRoleException(String message){
        super(message);
    }
}
