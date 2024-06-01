package com.harshit.stayease.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
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
