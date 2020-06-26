package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightBuilderService;
import com.gridnine.testing.service.exception.IllegalDatesCountException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilderServiceImpl implements FlightBuilderService {
    private static final LocalDateTime THREE_DAYS_FROM_NOW = LocalDateTime.now().plusDays(3);
    
    @Override
    public List<Flight> createFlights() {
        List<Flight> flights = null;

        try {
            flights = Arrays.asList(
                //A normal flight with two hour duration
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2)),

                //A normal multi segment flight
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                    THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(5)),

                //A flight departing in the past
                createFlight(THREE_DAYS_FROM_NOW.minusDays(6), THREE_DAYS_FROM_NOW),

                //A flight that departs before it arrives
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.minusHours(6)),

                //A flight with more than two hours ground time
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                    THREE_DAYS_FROM_NOW.plusHours(5), THREE_DAYS_FROM_NOW.plusHours(6)),

                //Another flight with more than two hours ground time
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                    THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(4),
                    THREE_DAYS_FROM_NOW.plusHours(6), THREE_DAYS_FROM_NOW.plusHours(7)));
        } catch (IllegalDatesCountException e) {
            System.out.println(e.getMessage());
        }

        return flights;
    }

    @Override
    public Flight createFlight(LocalDateTime... dates) throws IllegalDatesCountException {
        if ((dates.length % 2) != 0) {
            throw new IllegalDatesCountException("You must pass an even count of dates.");
        }

        List<Segment> segments = new ArrayList<>(dates.length / 2);

        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }

        return new Flight(segments);
    }
}
