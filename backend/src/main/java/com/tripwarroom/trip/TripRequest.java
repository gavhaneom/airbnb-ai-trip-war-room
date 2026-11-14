package com.tripwarroom.trip;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TripRequest(
    @NotBlank @Size(max = 120) String name,
    @NotBlank @Size(max = 160) String destination,
    @NotNull LocalDate startDate,
    @NotNull LocalDate endDate,
    @NotNull @DecimalMin("0.01") BigDecimal totalBudget,
    @NotNull @Min(1) @Max(50) Integer maxParticipants
) {}
