package com.example.restaurant_.booking.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name ="queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private long tableNumber;

    private String name;

    private Boolean active;

    private Timestamp timestamp;


    public Queue() {}

    public Queue(long tableNumber, String name, Boolean active, Timestamp timestamp) {
        this.tableNumber = tableNumber;
        this.name = name;
        this.active = active;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
