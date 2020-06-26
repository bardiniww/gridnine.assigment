package com.gridnine.testing.filter.certain;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.Map;

public class FindAllWithOnGroundDurationLessThanHoursFilter implements Filter {
    private final int hourCount;

    public FindAllWithOnGroundDurationLessThanHoursFilter(int hourCount) {
        this.hourCount = hourCount;
    }

    @Override
    public Map<String, Flight> doFilter(Map<String, Flight> flights) {
        return findAllWithOnGroundDurationLessThanHours(flights, hourCount);
    }
}
