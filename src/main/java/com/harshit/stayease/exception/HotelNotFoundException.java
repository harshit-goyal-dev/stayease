package com.harshit.stayease.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(String message){
        super(message);
    }
}
