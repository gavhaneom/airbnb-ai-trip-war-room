package com.tripwarroom.venue;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venue_metadata")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 160)
    private String destination;
    @Column(nullable = false, length = 160)
    private String name;
    @Column(nullable = false, length = 40)
    private String category;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerPerson;
    @Column(length = 250)
    private String dietaryTags;
    @Column(nullable = false, length = 5)
    private String hoursOpen;
    @Column(nullable = false, length = 5)
    private String hoursClose;
    private Double latitude;
    private Double longitude;
    @Column(length = 1000)
    private String description;

    protected Venue() {}

    public Venue(String destination, String name, String category, BigDecimal pricePerPerson,
                 String dietaryTags, String hoursOpen, String hoursClose,
                 Double latitude, Double longitude, String description) {
        this.destination = destination;
        this.name = name;
        this.category = category;
        this.pricePerPerson = pricePerPerson;
        this.dietaryTags = dietaryTags;
        this.hoursOpen = hoursOpen;
        this.hoursClose = hoursClose;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getDestination() { return destination; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public BigDecimal getPricePerPerson() { return pricePerPerson; }
    public String getDietaryTags() { return dietaryTags; }
    public String getHoursOpen() { return hoursOpen; }
    public String getHoursClose() { return hoursClose; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getDescription() { return description; }
}
