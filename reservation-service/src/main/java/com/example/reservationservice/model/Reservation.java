package com.example.reservationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "reservation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reservation {
    private Long id;
    private Long clientId;
    private Long motorbikeId;
    private String startDate;
    private String endDate;
}
