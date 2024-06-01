package com.harshit.stayease.service;

import com.harshit.stayease.dto.*;
import com.harshit.stayease.entity.Hotel;
import com.harshit.stayease.entity.User;
import com.harshit.stayease.exception.HotelNotFoundException;
import com.harshit.stayease.repository.HotelRepository;
import com.harshit.stayease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IUserService userService;

    @Override
    public List<HotelResponseDto> findAllHotels() {
        return hotelRepository.findAll().stream().map(hotel-> new HotelResponseDto(hotel)).collect(Collectors.toList());
    }

    @Override
    public HotelResponseDto createHotel(HotelRequestDto hotelRequestDto) {
        Hotel hotel = hotelRepository.save(new Hotel(hotelRequestDto));
        return new HotelResponseDto(hotel);
    }

    @Override
    public HotelResponseDto findHotelById(long id) {
        Hotel hotel = getHotelById(id);
        return new HotelResponseDto(hotel);
    }

    @Override
    public HotelResponseDto updateHotelById(long id, HotelRequestDto dto) {
        Hotel hotel = getHotelById(id);
        hotel.setName(dto.getName());
        hotel.setLocation(dto.getLocation());
        hotel.setDescription(dto.getDescription());
        hotel.setAvailableRooms(dto.getAvailableRooms());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return new HotelResponseDto(updatedHotel);    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotelById(long id) {
        Hotel hotel = getHotelById(id);
        hotelRepository.delete(hotel);
    }

    @Override
    public Hotel getHotelById(long id) {
       return hotelRepository.findById(id).orElseThrow(()->
               new HotelNotFoundException("Hotel not found with given id"));
    }

    @Override
    public void cancelBooking(long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @Override
    public BookingResponseDto bookRoom(long hotelId, BookingRequestDto dto) {
        Hotel hotel = getHotelById(hotelId);
        User customer = userService.getUserById(dto.getCustomerId());
        return bookingService.bookRoom(hotel,customer);
    }
}
