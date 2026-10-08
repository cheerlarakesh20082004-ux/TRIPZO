package com.tripzo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripzo.dto.RideResponse;
import com.tripzo.entity.Ride;
import com.tripzo.entity.User;
import com.tripzo.repository.RideRepository;
import com.tripzo.repository.UserRepository;
import com.tripzo.service.RideService;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public RideServiceImpl(RideRepository rideRepository, UserRepository userRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<RideResponse> findAll() {
        return rideRepository.findAll().stream()
            .map(RideResponse::fromEntity)
            .toList();
    }

    @Override
    public RideResponse findById(Long id) {
        Ride ride = rideRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ride not found: " + id));
        return RideResponse.fromEntity(ride);
    }

    @Override
    public RideResponse createRide(Ride ride) {
        User rider = userRepository.findById(ride.getRider().getId())
            .orElseThrow(() -> new IllegalArgumentException("Rider not found: " + ride.getRider().getId()));
        ride.setRider(rider);
        Ride saved = rideRepository.save(ride);
        return RideResponse.fromEntity(saved);
    }
}
