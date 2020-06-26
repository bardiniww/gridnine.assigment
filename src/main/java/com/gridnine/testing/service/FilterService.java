package com.gridnine.testing.service;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.Map;

public interface FilterService {
    Map<String, Flight> filter(Map<String, Flight> flights, Filter... filters);
}
