package com.gridnine.testing.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Flight {
    private final Long          id;
    private final boolean       isValid;
    private final List<Segment> segmentList;
    private final int           segmentCount;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    private final Long          totalFlightDuration;
    private final Long          secondsInFLight;
    private final Long          secondsOnGround;

    private static final AtomicLong sequenceId = new AtomicLong();

    public Flight(final List<Segment> segments) {
        id = sequenceId.incrementAndGet();
        isValid = segments.stream().allMatch(Segment::isValid);
        if (isValid) {
            segmentList = segments
                .stream()
                .sorted(Comparator.comparing(Segment::getDepartureDate))
                .collect(Collectors.toList());
            segmentCount = segments.size();
            departureDate = segmentList.get(0).getDepartureDate();
            arrivalDate =  segmentList.get(segmentList.size() - 1).getArrivalDate();
            totalFlightDuration = Duration.between(departureDate, arrivalDate).getSeconds();
            secondsInFLight = segmentList
                .stream()
                .mapToLong(Segment::getSecondsInFlight)
                .sum();
            secondsOnGround = Duration.between(departureDate, arrivalDate).getSeconds() - secondsInFLight;
        }
        else {
            segmentList = segments; segmentCount = 0; departureDate = LocalDateTime.now(); arrivalDate = LocalDateTime.now(); totalFlightDuration = 0L; secondsInFLight = 0L; secondsOnGround = 0L; //заглушка
        }
    }

    public Long getId() { return id; }

    public boolean isValid() { return isValid; }

    public List<Segment> getSegmentList() { return segmentList; }

    public int getSegmentCount() { return segmentCount; }

    public LocalDateTime getDepartureDate() { return departureDate; }

    public LocalDateTime getArrivalDate() { return arrivalDate; }

    public Long getTotalFlightDuration() { return totalFlightDuration; }

    public Long getSecondsInFLight() { return secondsInFLight; }

    public Long getSecondsOnGround() { return secondsOnGround; }

    @Override
    public String toString() {
        return segmentList.stream().map(Segment::toString).collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Flight flight = (Flight) o;

        return id.equals(flight.id);
    }

    @Override
    public int hashCode() { return id.hashCode(); }
}
