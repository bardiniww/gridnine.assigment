package com.gridnine.testing.service.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FilterService;

import java.util.*;

public class FilterServiceImpl implements FilterService {

    @Override
    public Map<String, Flight> filter(Map<String, Flight> flights, Filter... filters) {
        Map<String, Flight> filteredMap = null;

        for (int i = 0; i < filters.length; i++) {
            if (filteredMap == null) {
                filteredMap = filters[i].doFilter(flights);
            }
            else {
                filteredMap = filters[i].doFilter(filteredMap);
            }
        }

        return filteredMap;
    }
}
