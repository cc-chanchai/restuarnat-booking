package com.example.restaurant_.booking.repository;

import com.example.restaurant_.booking.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    List<Queue> findAllByActive(Boolean active);
}
