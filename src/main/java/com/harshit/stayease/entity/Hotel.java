package com.harshit.stayease.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harshit.stayease.dto.HotelRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @NotEmpty
    private String description;

    private int availableRooms;

    @OneToMany(mappedBy = "hotel")
    @JsonBackReference
    private List<Booking> bookings;


    public Hotel(HotelRequestDto dto) {
        name = dto.getName();
        location=dto.getLocation();
        description=dto.getDescription();
        availableRooms = dto.getAvailableRooms();
        bookings=new ArrayList<>();
    }
}
