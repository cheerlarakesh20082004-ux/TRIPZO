package com.tripzo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUsersShouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk());
    }

    @Test
    void createRideShouldReturnCreated() throws Exception {
        String requestBody = "{"
            + "\"riderId\":1,"
            + "\"pickupAddress\":\"MG Road\","
            + "\"dropAddress\":\"Indiranagar\","
            + "\"pickupLatitude\":12.9716,"
            + "\"pickupLongitude\":77.5946,"
            + "\"dropLatitude\":12.9812,"
            + "\"dropLongitude\":77.5960,"
            + "\"fare\":245.00,"
            + "\"estimatedDurationMinutes\":22,"
            + "\"distanceKm\":8.4"
            + "}";

        mockMvc.perform(post("/api/rides")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isCreated());
    }
}
