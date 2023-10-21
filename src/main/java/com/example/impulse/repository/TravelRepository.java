package com.example.impulse.repository;

import com.example.impulse.entities.travel.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findById(Long id);
}
