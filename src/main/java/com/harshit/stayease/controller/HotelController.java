package com.harshit.stayease.controller;

import com.harshit.stayease.dto.BookingRequestDto;
import com.harshit.stayease.dto.HotelRequestDto;
import com.harshit.stayease.dto.HotelResponseDto;
import com.harshit.stayease.service.IHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HotelController.APPLICATION_ENDPOINT)
public class HotelController {
    protected static final String APPLICATION_ENDPOINT = "/stayease/api/v1";
    private static final String HOTEL_ENDPOINT = "hotels";

    @Autowired
    private IHotelService hotelService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(HOTEL_ENDPOINT)
    public ResponseEntity<HotelResponseDto> createHotel(@RequestBody @Valid HotelRequestDto hotelRequestDto
    ){
        return ResponseEntity.ok().body(hotelService.createHotel(hotelRequestDto
        ));
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping(HOTEL_ENDPOINT+"/{hotelId}/book")
    public ResponseEntity<String> bookRoomInHotel(@PathVariable long hotelId, @RequestBody @Valid BookingRequestDto bookingRequestDto){
        hotelService.bookRoom(hotelId, bookingRequestDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("Room Booked succesfully");
    }
    @PreAuthorize("hasAuthority('MANAGER')")
    @DeleteMapping("bookings/{bookingId}")
    public ResponseEntity<String> cancelBookingInHotel(@PathVariable long bookingId){
        hotelService.cancelBooking(bookingId);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body("Booking canceled succesfully");
    }
    @GetMapping(HOTEL_ENDPOINT)
    public ResponseEntity<List<HotelResponseDto>> getHotels(){
        return ResponseEntity.ok().body(hotelService.findAllHotels());
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN','CUSTOMER')")
    @GetMapping(HOTEL_ENDPOINT+"/{id}")
    public ResponseEntity<HotelResponseDto> getHotelById(@PathVariable long id){
        return ResponseEntity.ok().body(hotelService.findHotelById(id));
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping(HOTEL_ENDPOINT+"/{id}")
    public ResponseEntity<HotelResponseDto> updateHotelById(@PathVariable long id, @RequestBody @Valid HotelRequestDto
            hotelRequestDto
    ){
        return ResponseEntity.ok().body(hotelService.updateHotelById(id,hotelRequestDto));

    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(HOTEL_ENDPOINT+"/{id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable long id){
        hotelService.deleteHotelById(id);
        return ResponseEntity.ok().body("Deleted Successfully");

    }


}
