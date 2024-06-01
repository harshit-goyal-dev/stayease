package com.harshit.stayease.service;

import com.harshit.stayease.dto.BookingResponseDto;
import com.harshit.stayease.entity.Booking;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;
import com.harshit.stayease.enums.Role;
import com.harshit.stayease.exception.BookingNotFoundException;
import com.harshit.stayease.exception.RoomNotAvailableException;
import com.harshit.stayease.repository.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiveTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    private Booking booking1;
    private Booking booking2;

    private Hotel hotel1;
    private Hotel hotel2;

    private User customer1;
    private User customer2;
    private BookingResponseDto bookingResponseDto2;

    @BeforeEach
    void setUp() {


        customer1 = new User(1L, "abcd", "xyz", "abcd@gmail.com",
                "qwertyui", Role.CUSTOMER, new ArrayList<Booking>());
        customer2 = new User(2L, "zxc", "xyz", "pqr@gmail.com",
                "qwertyui", Role.CUSTOMER, new ArrayList<Booking>());

        hotel1 = new Hotel(1L, "The Leela", "Delhi",
                "description", 4, new ArrayList<>());
        hotel2 = new Hotel(2L, "The Raddison", "Gurugram",
                "description", 0, new ArrayList<>());

        booking1 = new Booking(1L,hotel1, customer1);
        booking2 = new Booking(2L, hotel2, customer2);
        bookingResponseDto2 = new BookingResponseDto(booking2);

    }

//    @Test
//    public void bookRoomTest_ShouldThrowBookNotFoundException() throws BookNotFoundException{
//        when(bookRepository.findById(5L)).thenThrow(BookNotFoundException.class);
//        Assertions.assertThrows(BookNotFoundException.class, () -> bookService
//                .rentBook(5L,new RentRequestDto(ArgumentMatchers.anyLong())));
//    }

    @Test
    public void bookRoomTest_ShouldThrowRoomNotAvailableException() {
       // when(bookingRepository.save(booking2)).thenReturn(booking2);
        // BookingResponseDto dto = bookingService.bookRoom(hotel2,customer2);

        Assertions.assertThrows(RoomNotAvailableException.class, () -> bookingService.
                bookRoom(hotel2, customer2));
    }

//    @Test
//    public void bookRoomTest_ShouldThrowBookRentalLimitExceededException(){
//        when(bookRepository.findById(3L)).thenReturn(Optional.of(book3));
//        when(userService.getUserById(1L)).thenReturn(user1);
//
//        Assertions.assertThrows(BookRentalLimitExceededException.class, () -> bookService
//                .rentBook(3L,new RentRequestDto(1L)));
//    }

    @Test
    public void bookRoomTest_ShouldBookRoom() {
        when(bookingRepository.save(ArgumentMatchers.any(Booking.class))).thenReturn(booking1);
        BookingResponseDto dto = bookingService.bookRoom(hotel1, customer1);
        Assertions.assertEquals(1, dto.getId());
        Assertions.assertEquals(3,dto.getHotel().getAvailableRooms());
    }

    @Test
    public void cancelBookingTest_ShouldThrowBookingNotFoundException() {
        when(bookingRepository.findById(3L)).thenThrow(BookingNotFoundException.class);
        Assertions.assertThrows(BookingNotFoundException.class, () -> bookingService.cancelBooking(3L));
    }

    @Test
    public void cancelBookingTest_ShouldCancelBooking() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking1));
        doNothing().when(bookingRepository).delete(booking1);
        bookingService.cancelBooking(1L);
        verify(bookingRepository, times(1)).delete(booking1);
    }
}