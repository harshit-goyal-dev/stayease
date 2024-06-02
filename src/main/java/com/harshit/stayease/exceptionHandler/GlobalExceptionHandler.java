package com.harshit.stayease.exceptionHandler;

import com.harshit.stayease.exception.*;
import com.harshit.stayease.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookingNotFoundException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomNotAvailableException.class)
    public ResponseEntity<String> handleBookNotAvailableException(RoomNotAvailableException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<String> handleBookNotRentedException(UserAlreadyRegisteredException exception){
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handleBookRentalLimitExceededException(HotelNotFoundException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<String> handleInvalidRoleException(InvalidRoleException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception exception){
        log.error(exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
