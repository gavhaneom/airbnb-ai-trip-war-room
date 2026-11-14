package com.tripwarroom.trip;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trips")
@CrossOrigin(origins = "http://localhost:5173")
public class TripController {
    private final TripRepository repository;

    public TripController(TripRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Trip not found: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trip createTrip(@Valid @RequestBody TripRequest request) {
        if (request.endDate().isBefore(request.startDate())) {
            throw new IllegalArgumentException("End date must be on or after start date.");
        }
        Trip trip = new Trip(request.name(), request.destination(), request.startDate(),
            request.endDate(), request.totalBudget(), request.maxParticipants());
        return repository.save(trip);
    }
}
