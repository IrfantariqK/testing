package com.example.testing.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "locations")
public class Location {
    @Id
    private String id;
    private String name;
    private List<Schedule> schedules;

    // Constructors
    public Location() {
        // Default constructor
    }

    public Location(String name, List<Schedule> schedules) {
        this.name = name;
        this.schedules = schedules;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    // Other methods as needed
}
