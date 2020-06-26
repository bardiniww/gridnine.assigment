package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class FlightRepository {
    private final Map<String, Flight> flights;

    private static final AtomicReference<FlightRepository> INSTANCE = new AtomicReference<>();

    private FlightRepository() {
        flights = new HashMap<>();
    }

    public static FlightRepository getInstance() {
        if(INSTANCE.get() == null) {
            INSTANCE.set(new FlightRepository());
        }

        return INSTANCE.get();
    }

    public void add(Flight flight) {
        flights.put(String.valueOf(flight.getId()), flight);
    }

    public void addAll(List<Flight> list) {
        list.forEach(entity -> flights.put(String.valueOf(entity.getId()), entity));
    }

    public void addAll(Map<String, Flight> map) {
        for (Map.Entry<String, Flight> pair : map.entrySet()) {
            if (pair.getKey().contentEquals(String.valueOf(pair.getValue().getId()))) {
                flights.put(pair.getKey(), pair.getValue());
            }
        }
    }

    public void removeById(long id) {
        String key = String.valueOf(id);
        if (flights.containsKey(key)) {
            flights.remove(String.valueOf(id));
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean existsById(long id) {
        return flights.containsKey(String.valueOf(id));
    }

    public Flight findById(long id) {
        String key = String.valueOf(id);
        if (flights.containsKey(key)) {
            return flights.get(String.valueOf(id));
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Flight> findAll() {
        return flights;
    }

    public void clear() {
        flights.clear();
    }
}
