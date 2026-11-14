package com.tripwarroom.venue;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@CrossOrigin(origins = "http://localhost:5173")
public class VenueController {
    private final VenueRepository repository;

    public VenueController(VenueRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Venue> getVenues(@RequestParam(required = false) String destination) {
        return (destination == null || destination.isBlank())
            ? repository.findAll()
            : repository.findByDestinationContainingIgnoreCase(destination);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venue createVenue(@Valid @RequestBody VenueRequest request) {
        Venue venue = new Venue(request.destination(), request.name(), request.category(),
            request.pricePerPerson(), request.dietaryTags(), request.hoursOpen(),
            request.hoursClose(), request.latitude(), request.longitude(), request.description());
        return repository.save(venue);
    }
}
