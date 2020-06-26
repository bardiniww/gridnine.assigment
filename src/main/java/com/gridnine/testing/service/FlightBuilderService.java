package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.exception.IllegalDatesCountException;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightBuilderService {
    List<Flight> createFlights() throws IllegalDatesCountException;

    Flight createFlight(final LocalDateTime... dates) throws IllegalDatesCountException;
}
