package com.harshit.stayease.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @NonNull
    private Hotel hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    @NonNull
    private User customer;

    public Booking(Hotel hotel, User customer) {

        this.hotel = hotel;
        this.customer = customer;
    }
}
