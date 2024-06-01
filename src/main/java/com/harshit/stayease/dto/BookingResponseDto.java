package com.harshit.stayease.dto;

import com.harshit.stayease.entity.Booking;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {

    private long id;

    private Hotel hotel;

    private User customer;

    public BookingResponseDto(Booking booking) {
        id = booking.getId();
        hotel = booking.getHotel();
        customer = booking.getCustomer();
    }
}
