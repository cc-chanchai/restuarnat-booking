package com.example.restaurant_.booking;

import com.example.restaurant_.booking.model.Booking;
import com.example.restaurant_.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class RestaurantBookingApplication {
	@Autowired
	private BookingRepository bookingRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantBookingApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BookingRepository bookingRepository){
		return args -> {
			bookingRepository.save(new Booking(new Timestamp(new Date().getTime()), false, 1, "cc-chanchai"));
			bookingRepository.save(new Booking(new Timestamp(new Date().getTime()), false, 2, "t2"));
			bookingRepository.save(new Booking(new Timestamp(new Date().getTime()), false, 3, "t3"));
			bookingRepository.save(new Booking(new Timestamp(new Date().getTime()), true, 4, ""));
			bookingRepository.save(new Booking(new Timestamp(new Date().getTime()), true, 5, ""));
		};
	}
}
