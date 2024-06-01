package com.harshit.stayease.service;

import com.harshit.stayease.dto.BookingRequestDto;
import com.harshit.stayease.dto.BookingResponseDto;
import com.harshit.stayease.dto.HotelRequestDto;
import com.harshit.stayease.dto.HotelResponseDto;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;

import java.util.List;

public interface IBookingService {

    public BookingResponseDto bookRoom(Hotel hotel, User customer);

    public void cancelBooking(long bookingId);
}
