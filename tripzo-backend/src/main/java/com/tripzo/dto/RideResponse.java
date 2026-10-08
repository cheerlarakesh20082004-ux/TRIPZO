package com.tripzo.dto;

import java.math.BigDecimal;

import com.tripzo.entity.Ride;

public record RideResponse(Long id, String riderName, String pickupAddress, String dropAddress, String status, BigDecimal fare) {
    public static RideResponse fromEntity(Ride ride) {
        String riderName = ride.getRider() != null ? ride.getRider().getFullName() : "Unknown";
        return new RideResponse(
            ride.getId(),
            riderName,
            ride.getPickupAddress(),
            ride.getDropAddress(),
            ride.getStatus().name(),
            ride.getFare()
        );
    }
}
