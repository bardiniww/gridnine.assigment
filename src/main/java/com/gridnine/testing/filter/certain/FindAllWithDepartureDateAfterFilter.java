package com.gridnine.testing.filter.certain;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.Map;

public class FindAllWithDepartureDateAfterFilter implements Filter {
    private final LocalDateTime date;

    public FindAllWithDepartureDateAfterFilter(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public Map<String, Flight> doFilter(Map<String, Flight> flights) {
        return findAllWithDepartureDateAfter(flights, date);
    }
}
