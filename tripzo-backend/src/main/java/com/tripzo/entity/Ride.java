package com.tripzo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tripzo.enums.RideStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id", nullable = false)
    private User rider;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "pickup_latitude", nullable = false)
    private BigDecimal pickupLatitude;

    @Column(name = "pickup_longitude", nullable = false)
    private BigDecimal pickupLongitude;

    @Column(name = "drop_latitude", nullable = false)
    private BigDecimal dropLatitude;

    @Column(name = "drop_longitude", nullable = false)
    private BigDecimal dropLongitude;

    @Column(name = "pickup_address", nullable = false)
    private String pickupAddress;

    @Column(name = "drop_address", nullable = false)
    private String dropAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RideStatus status = RideStatus.REQUESTED;

    @Column(nullable = false)
    private BigDecimal fare = BigDecimal.ZERO;

    @Column(name = "estimated_duration_minutes", nullable = false)
    private Integer estimatedDurationMinutes = 0;

    @Column(name = "distance_km", nullable = false)
    private BigDecimal distanceKm = BigDecimal.ZERO;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    public Ride() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        if (this.status == RideStatus.IN_PROGRESS && this.startedAt == null) {
            this.startedAt = LocalDateTime.now();
        }
        if (this.status == RideStatus.COMPLETED && this.completedAt == null) {
            this.completedAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getRider() { return rider; }
    public void setRider(User rider) { this.rider = rider; }

    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }

    public BigDecimal getPickupLatitude() { return pickupLatitude; }
    public void setPickupLatitude(BigDecimal pickupLatitude) { this.pickupLatitude = pickupLatitude; }

    public BigDecimal getPickupLongitude() { return pickupLongitude; }
    public void setPickupLongitude(BigDecimal pickupLongitude) { this.pickupLongitude = pickupLongitude; }

    public BigDecimal getDropLatitude() { return dropLatitude; }
    public void setDropLatitude(BigDecimal dropLatitude) { this.dropLatitude = dropLatitude; }

    public BigDecimal getDropLongitude() { return dropLongitude; }
    public void setDropLongitude(BigDecimal dropLongitude) { this.dropLongitude = dropLongitude; }

    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }

    public String getDropAddress() { return dropAddress; }
    public void setDropAddress(String dropAddress) { this.dropAddress = dropAddress; }

    public RideStatus getStatus() { return status; }
    public void setStatus(RideStatus status) { this.status = status; }

    public BigDecimal getFare() { return fare; }
    public void setFare(BigDecimal fare) { this.fare = fare; }

    public Integer getEstimatedDurationMinutes() { return estimatedDurationMinutes; }
    public void setEstimatedDurationMinutes(Integer estimatedDurationMinutes) { this.estimatedDurationMinutes = estimatedDurationMinutes; }

    public BigDecimal getDistanceKm() { return distanceKm; }
    public void setDistanceKm(BigDecimal distanceKm) { this.distanceKm = distanceKm; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}
