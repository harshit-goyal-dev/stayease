package com.harshit.stayease.service;

import com.harshit.stayease.dto.BookingResponseDto;
import com.harshit.stayease.entity.Booking;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;
import com.harshit.stayease.exception.BookingNotFoundException;
import com.harshit.stayease.exception.RoomNotAvailableException;
import com.harshit.stayease.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService{


    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public BookingResponseDto bookRoom(Hotel hotel, User customer) {
        if(hotel.getAvailableRooms()<=0)
            throw new RoomNotAvailableException("We don't have any available rooms. Please try later");

        Booking booking = new Booking(hotel,customer);
        hotel.setAvailableRooms(hotel.getAvailableRooms()-1);
        hotel.getBookings().add(booking);
        customer.getBookings().add(booking);
        return new BookingResponseDto(bookingRepository.save(booking));

    }
    public Booking getBookingById(long id){
        return bookingRepository.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking with given id is not found"));
    }
    @Override
    public void cancelBooking(long bookingId) {
        Booking booking = getBookingById(bookingId);
        Hotel hotel = booking.getHotel();
        User customer = booking.getCustomer();
        hotel.setAvailableRooms(hotel.getAvailableRooms()+1);
        hotel.getBookings().remove(booking);
        customer.getBookings().remove(booking);
        bookingRepository.delete(booking);
    }
}
