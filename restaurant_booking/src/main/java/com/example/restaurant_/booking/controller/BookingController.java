package com.example.restaurant_.booking.controller;

import com.example.restaurant_.booking.model.Booking;
import com.example.restaurant_.booking.model.Queue;
import com.example.restaurant_.booking.repository.BookingRepository;
import com.example.restaurant_.booking.repository.QueueRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    QueueRepository queueRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBooking(){
        List<Booking> bookings = bookingRepository.findAll();
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> createBookings(@RequestBody Booking booking){
        try{
            booking.setTimestamp(new Timestamp(new Date().getTime()));
            Booking book = bookingRepository.save(booking);
            simpMessagingTemplate.convertAndSend("/topic/messages", book);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //for User booking
    @PutMapping("/bookings")
    public ResponseEntity<?> updateBookings(@RequestBody Booking booking){
        try{
            Booking oldBooking = bookingRepository.findById(booking.getId()).get();
            oldBooking.setTimestamp(new Timestamp(new Date().getTime()));
            oldBooking.setIsBooking(booking.getIsBooking());
            Queue queue = new Queue(oldBooking.getTableNumber(),oldBooking.getCustomerName(),oldBooking.getIsBooking(),oldBooking.getTimestamp());
            queueRepository.save(queue);

            List<Queue> activeQueue = queueRepository.findAllByActive(true);
            activeQueue.sort((Queue o1, Queue o2) -> (int) (o1.getTimestamp().getTime() - o2.getTimestamp().getTime()));
            simpMessagingTemplate.convertAndSend("/topic/messages", activeQueue);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //for admin

}
