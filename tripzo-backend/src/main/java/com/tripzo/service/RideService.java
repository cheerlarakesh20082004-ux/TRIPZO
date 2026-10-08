package com.tripzo.service;

import java.util.List;

import com.tripzo.dto.RideResponse;
import com.tripzo.entity.Ride;

public interface RideService {
    List<RideResponse> findAll();
    RideResponse findById(Long id);
    RideResponse createRide(Ride ride);
}
