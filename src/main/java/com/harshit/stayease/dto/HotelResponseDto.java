package com.harshit.stayease.dto;

import com.harshit.stayease.entity.Hotel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponseDto {

    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @NotEmpty
    private String description;

    private int availableRooms;

    public HotelResponseDto(Hotel hotel) {
        id = hotel.getId();;
        name = hotel.getName();;
        location=hotel.getLocation();
        description= hotel.getDescription();;
        availableRooms= hotel.getAvailableRooms();
    }
}
