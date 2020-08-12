package com.example.restaurant_.booking.repository;

import com.example.restaurant_.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {


}
