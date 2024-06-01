package com.harshit.stayease.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(String message){
        super(message);
    }
}
