package com.tripzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripzo.entity.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
