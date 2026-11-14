package com.tripwarroom.venue;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record VenueRequest(
    @NotBlank String destination,
    @NotBlank @Size(max = 160) String name,
    @NotBlank String category,
    @NotNull @DecimalMin("0.00") BigDecimal pricePerPerson,
    String dietaryTags,
    @NotBlank @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$") String hoursOpen,
    @NotBlank @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$") String hoursClose,
    @DecimalMin("-90.0") @DecimalMax("90.0") Double latitude,
    @DecimalMin("-180.0") @DecimalMax("180.0") Double longitude,
    @Size(max = 1000) String description
) {}
