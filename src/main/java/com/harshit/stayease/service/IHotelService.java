package com.harshit.stayease.service;

import com.harshit.stayease.dto.*;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IHotelService {

    public List<HotelResponseDto> findAllHotels();

    public HotelResponseDto createHotel(HotelRequestDto hotelRequestDto);

    public HotelResponseDto findHotelById(long id);

    public  HotelResponseDto updateHotelById(long id, HotelRequestDto hotelRequestDto);

    public  Hotel updateHotel(Hotel hotel);

    public void deleteHotelById(long id);

    public Hotel getHotelById(long id);

    public void cancelBooking(long bookingId);

    public BookingResponseDto bookRoom(long hotelId, BookingRequestDto bookingRequestDto);
}
