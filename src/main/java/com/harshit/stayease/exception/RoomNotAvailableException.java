package com.harshit.stayease.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoomNotAvailableException extends RuntimeException{

    public RoomNotAvailableException(String message){
        super(message);
    }
}
