package com.tripzo.dto;

import java.math.BigDecimal;

public record CreateRideRequest(
    Long riderId,
    String pickupAddress,
    String dropAddress,
    BigDecimal pickupLatitude,
    BigDecimal pickupLongitude,
    BigDecimal dropLatitude,
    BigDecimal dropLongitude,
    BigDecimal fare,
    Integer estimatedDurationMinutes,
    BigDecimal distanceKm
) {
}
