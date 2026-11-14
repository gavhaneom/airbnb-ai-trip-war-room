package com.tripwarroom.trip;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 160)
    private String destination;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal totalBudget;

    @Column(nullable = false)
    private Integer maxParticipants;

    @Column(nullable = false, length = 20)
    private String status = "DRAFTING";

    protected Trip() {}

    public Trip(String name, String destination, LocalDate startDate, LocalDate endDate,
                BigDecimal totalBudget, Integer maxParticipants) {
        this.name = name;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBudget = totalBudget;
        this.maxParticipants = maxParticipants;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDestination() { return destination; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public BigDecimal getTotalBudget() { return totalBudget; }
    public Integer getMaxParticipants() { return maxParticipants; }
    public String getStatus() { return status; }
}
