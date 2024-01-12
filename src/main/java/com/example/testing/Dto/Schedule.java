package com.example.testing.Dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Schedule {
    private String id;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<String> skipDays;

    public Schedule() {
        this.id = UUID.randomUUID().toString();
    }

    public Schedule(LocalDateTime start, LocalDateTime end, List<String> skipDays) {
        this.id = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
        this.skipDays = skipDays;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public List<String> getSkipDays() {
        return skipDays;
    }

    public void setSkipDays(List<String> skipDays) {
        this.skipDays = skipDays;
    }

    
    public boolean overlapsWith(Schedule other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }
}


