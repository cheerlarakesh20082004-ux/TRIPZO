package com.tripzo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tripzo.dto.CreateRideRequest;
import com.tripzo.dto.RideResponse;
import com.tripzo.entity.Ride;
import com.tripzo.entity.User;
import com.tripzo.enums.RideStatus;
import com.tripzo.service.RideService;

@RestController
@RequestMapping("/api")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/rides")
    public List<RideResponse> getRides() {
        return rideService.findAll();
    }

    @GetMapping("/rides/{id}")
    public RideResponse getRideById(@PathVariable Long id) {
        return rideService.findById(id);
    }

    @PostMapping("/rides")
    @ResponseStatus(HttpStatus.CREATED)
    public RideResponse createRide(@RequestBody CreateRideRequest request) {
        User rider = new User();
        rider.setId(request.riderId());

        Ride ride = new Ride();
        ride.setRider(rider);
        ride.setPickupAddress(request.pickupAddress());
        ride.setDropAddress(request.dropAddress());
        ride.setPickupLatitude(request.pickupLatitude());
        ride.setPickupLongitude(request.pickupLongitude());
        ride.setDropLatitude(request.dropLatitude());
        ride.setDropLongitude(request.dropLongitude());
        ride.setFare(request.fare());
        ride.setEstimatedDurationMinutes(request.estimatedDurationMinutes());
        ride.setDistanceKm(request.distanceKm());
        ride.setStatus(RideStatus.REQUESTED);

        return rideService.createRide(ride);
    }
}
