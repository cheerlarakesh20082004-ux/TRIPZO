USE tripzo_db;

INSERT INTO users (full_name, email, phone, password_hash, role, is_active)
VALUES
    ('Aisha Verma', 'aisha@example.com', '+919900000001', '$2a$10$dummyhash1', 'RIDER', 1),
    ('Rohan Iyer', 'rohan@example.com', '+919900000002', '$2a$10$dummyhash2', 'RIDER', 1),
    ('Neha Sharma', 'neha.driver@example.com', '+919900000003', '$2a$10$dummyhash3', 'DRIVER', 1),
    ('Karan Singh', 'karan.driver@example.com', '+919900000004', '$2a$10$dummyhash4', 'DRIVER', 1),
    ('Tripzo Admin', 'admin@tripzo.com', '+919900000005', '$2a$10$dummyhash5', 'ADMIN', 1)
ON DUPLICATE KEY UPDATE
    full_name = VALUES(full_name),
    phone = VALUES(phone),
    password_hash = VALUES(password_hash),
    role = VALUES(role),
    is_active = VALUES(is_active);

INSERT INTO drivers (user_id, license_number, vehicle_type, rating, total_trips, is_available)
VALUES
    (3, 'DL-202401', 'BIKE', 4.85, 128, 1),
    (4, 'DL-202402', 'CAB', 4.72, 86, 1)
ON DUPLICATE KEY UPDATE
    license_number = VALUES(license_number),
    vehicle_type = VALUES(vehicle_type),
    rating = VALUES(rating),
    total_trips = VALUES(total_trips),
    is_available = VALUES(is_available);

INSERT INTO vehicles (driver_id, model, color, plate_number, registration_number, vehicle_type, is_verified)
VALUES
    (1, 'Honda Activa 6G', 'Blue', 'KA01AB1234', 'KA01REG101', 'BIKE', 1),
    (2, 'Toyota Etios', 'Silver', 'KA05CD5678', 'KA05REG202', 'CAB', 1)
ON DUPLICATE KEY UPDATE
    model = VALUES(model),
    color = VALUES(color),
    plate_number = VALUES(plate_number),
    registration_number = VALUES(registration_number),
    vehicle_type = VALUES(vehicle_type),
    is_verified = VALUES(is_verified);

INSERT INTO rides (rider_id, driver_id, pickup_latitude, pickup_longitude, drop_latitude, drop_longitude, pickup_address, drop_address, status, fare, estimated_duration_minutes, distance_km)
VALUES
    (1, 1, 12.9716, 77.5946, 12.9812, 77.5960, 'MG Road, Bengaluru', 'Indiranagar, Bengaluru', 'COMPLETED', 245.00, 22, 8.40),
    (2, 2, 13.0050, 77.5700, 13.0450, 77.6300, 'Whitefield, Bengaluru', 'Koramangala, Bengaluru', 'IN_PROGRESS', 420.00, 31, 14.70)
ON DUPLICATE KEY UPDATE
    driver_id = VALUES(driver_id),
    pickup_latitude = VALUES(pickup_latitude),
    pickup_longitude = VALUES(pickup_longitude),
    drop_latitude = VALUES(drop_latitude),
    drop_longitude = VALUES(drop_longitude),
    pickup_address = VALUES(pickup_address),
    drop_address = VALUES(drop_address),
    status = VALUES(status),
    fare = VALUES(fare),
    estimated_duration_minutes = VALUES(estimated_duration_minutes),
    distance_km = VALUES(distance_km);

INSERT INTO payments (ride_id, amount, payment_method, payment_status, transaction_reference)
VALUES
    (1, 245.00, 'UPI', 'SUCCESS', 'TRX-1001'),
    (2, 420.00, 'CARD', 'PENDING', 'TRX-1002')
ON DUPLICATE KEY UPDATE
    amount = VALUES(amount),
    payment_method = VALUES(payment_method),
    payment_status = VALUES(payment_status),
    transaction_reference = VALUES(transaction_reference);

INSERT INTO notifications (user_id, title, message, type, is_read)
VALUES
    (1, 'Ride Completed', 'Your trip from MG Road to Indiranagar has been completed.', 'BOOKING', 0),
    (3, 'New Ride Request', 'A rider has requested a pickup near MG Road.', 'BOOKING', 0),
    (5, 'System Update', 'Daily revenue report is ready for download.', 'SYSTEM', 1)
ON DUPLICATE KEY UPDATE
    title = VALUES(title),
    message = VALUES(message),
    type = VALUES(type),
    is_read = VALUES(is_read);
