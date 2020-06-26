package com.gridnine.testing.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Segment {
    private final Long          id;
    private final boolean       isValid;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    private final Long          secondsInFlight;

    private static final String     FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm";
    private static final AtomicLong SEQUENCE_ID = new AtomicLong();

    public Segment(final LocalDateTime departureDate, final LocalDateTime arrivalDate) {
        id = SEQUENCE_ID.incrementAndGet();
        this.departureDate = Objects.requireNonNull(departureDate);
        this.arrivalDate = Objects.requireNonNull(arrivalDate);

        if (departureDate.isBefore(arrivalDate)) {
            secondsInFlight = Duration.between(departureDate, arrivalDate).getSeconds();
            isValid = true;
        }
        else {
            secondsInFlight = 0L;
            isValid = false;
        }
    }

    public Long getId() { return id; }

    public boolean isValid() { return isValid; }

    public LocalDateTime getDepartureDate() { return departureDate; }

    public LocalDateTime getArrivalDate() { return arrivalDate; }
    
    public Long getSecondsInFlight() { return secondsInFlight; }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_PATTERN);
        return '[' + departureDate.format(dateTimeFormatter) + '|' + arrivalDate.format(dateTimeFormatter) + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Segment segment = (Segment) o;

        return id.equals(segment.id);
    }

    @Override
    public int hashCode() { return id.hashCode(); }

}
