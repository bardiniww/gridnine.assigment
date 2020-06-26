/*
 * Copyright (c) 2008-2020
 * LANIT
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * LANIT and its licensors, if any.
 *
 * $
 */
package com.gridnine.testing.filter.certain;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;
import com.gridnine.testing.service.impl.FlightBuilderServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAllWithDepartureDateAfterFilterTest {
    private final LocalDateTime TARGET_DATE = LocalDateTime.now();
    private Filter findAllWithDepartureDateAfterFilter;
    private Map<String, Flight> testData;

    @Before
    public void setUp() {
        findAllWithDepartureDateAfterFilter = new FindAllWithDepartureDateAfterFilter(TARGET_DATE);
        FlightRepository.getInstance().addAll(new FlightBuilderServiceImpl().createFlights());
        testData = FlightRepository.getInstance().findAll();
    }

    @Test
    public void testWithFilterReturnsOnlyFlightsWithDepartureDateAfterTargetDate() {
        Map<String, Flight> filteredData = findAllWithDepartureDateAfterFilter.doFilter(testData);

        List<LocalDateTime> departureValues = filteredData.values().stream().map(Flight::getDepartureDate).collect(Collectors.toList());

        Assert.assertTrue("FindAllWithDepartureDateAfterFilter works incorrect", departureValues.stream().allMatch(date -> date.isAfter(TARGET_DATE)));
    }

    @After
    public void tearDown() {
        FlightRepository.getInstance().clear();
    }
}
