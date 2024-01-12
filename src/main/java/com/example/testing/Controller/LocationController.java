package com.example.testing.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.SchedulingException;
import org.springframework.web.bind.annotation.*;

import com.example.testing.Dto.Location;
import com.example.testing.Service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Object> addLocation(@RequestBody Location location) {
        try {
            Location savedLocation = locationService.saveLocation(location);
            return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
        } catch (SchedulingException ex) {
            // Handle scheduling overlap error with a specific message
            return new ResponseEntity<>("Schedules overlap please check your time ", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable String id) {
        return locationService.getLocationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable String id) {
        locationService.deleteLocation(id);
    }
}
