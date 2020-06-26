package com.gridnine.testing.filter.certain;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.Map;

public class FindAllValidFilter implements Filter {

    @Override
    public Map<String, Flight> doFilter(Map<String, Flight> flights) {
        return findAllValid(flights);
    }
}
