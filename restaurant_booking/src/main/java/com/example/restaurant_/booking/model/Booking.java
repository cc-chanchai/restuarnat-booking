package com.example.restaurant_.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Timestamp;

//@Data
@NoArgsConstructor
@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp timestamp;

    private Boolean isBooking;

    private long tableNumber;

    private String customerName;

    public Booking(Timestamp timestamp, Boolean isBooking, long tableNumber, String customerName) {
        this.timestamp = timestamp;
        this.isBooking = isBooking;
        this.tableNumber = tableNumber;
        this.customerName = customerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsBooking(Boolean booking) {
        isBooking = booking;
    }

    public void setTableNumber(long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsBooking() {
        return isBooking;
    }

    public Long getId() {
        return id;
    }

    public long getTableNumber() {
        return tableNumber;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
}