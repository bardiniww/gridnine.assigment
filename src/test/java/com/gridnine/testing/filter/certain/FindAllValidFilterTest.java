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

import java.util.Map;

public class FindAllValidFilterTest {
    private Filter findAllValidFilter;
    private Map<String, Flight> testData;

    @Before
    public void setUp() {
        findAllValidFilter = new FindAllValidFilter();
        FlightRepository.getInstance().addAll(new FlightBuilderServiceImpl().createFlights());
        testData = FlightRepository.getInstance().findAll();
    }

    @Test
    public void testWithFilterReturnOnlyValidValues() {
        Map<String, Flight> filteredData = findAllValidFilter.doFilter(testData);

        Assert.assertTrue("FindAllValidFilter works incorrect.", filteredData.values().stream().allMatch(Flight::isValid));
    }

    @After
    public void tearDown() {
        FlightRepository.getInstance().clear();
    }
}
