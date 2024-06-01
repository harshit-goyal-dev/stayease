package com.harshit.stayease.repository;

import com.harshit.stayease.entity.Booking;
import com.harshit.stayease.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
