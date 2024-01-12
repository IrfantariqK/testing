package com.example.testing.Service;

import com.example.testing.Dto.Location;
import com.example.testing.Dto.Schedule;
import com.example.testing.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.SchedulingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location saveLocation(Location location) {
        validateSchedules(location.getSchedules());
        return locationRepository.save(location);
    }

    private void validateSchedules(List<Schedule> schedules) {
        for (int i = 0; i < schedules.size() - 1; i++) {
            for (int j = i + 1; j < schedules.size(); j++) {
                Schedule schedule1 = schedules.get(i);
                Schedule schedule2 = schedules.get(j);

                if (schedule1.overlapsWith(schedule2)) {
                    throw new SchedulingException("Schedules overlap could not be successful " + schedule1 + " and " + schedule2);
                }
            }
        }
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
    }

    public void deleteLocation(String id) {
        locationRepository.deleteById(id);
    }
}
