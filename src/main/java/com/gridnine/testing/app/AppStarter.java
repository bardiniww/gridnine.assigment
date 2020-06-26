package com.gridnine.testing.app;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.certain.FindAllValidFilter;
import com.gridnine.testing.filter.certain.FindAllWithDepartureDateAfterFilter;
import com.gridnine.testing.filter.certain.FindAllWithOnGroundDurationLessThanHoursFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;
import com.gridnine.testing.service.impl.FilterServiceImpl;
import com.gridnine.testing.service.impl.FlightBuilderServiceImpl;
import com.gridnine.testing.service.impl.PrinterServiceImpl;

import java.time.LocalDateTime;
import java.util.Map;

public class AppStarter {

    private AppStarter() {}

    public static void start() {
        FlightBuilderServiceImpl flightBuilderService = new FlightBuilderServiceImpl();
        FilterServiceImpl filterService = new FilterServiceImpl();
        PrinterServiceImpl printerService = new PrinterServiceImpl();

        FlightRepository.getInstance().addAll(flightBuilderService.createFlights());
        Map<String, Flight> testData = FlightRepository.getInstance().findAll();

        Filter findAllWithDepartureDateAfterFilter = new FindAllWithDepartureDateAfterFilter(LocalDateTime.now());
        Filter findAllValidFilter = new FindAllValidFilter();
        Filter findAllWithOnGroundDurationLessThanHoursFilter = new FindAllWithOnGroundDurationLessThanHoursFilter(2);

        Map<String, Flight> filteredMapTask1 = filterService.filter(testData, findAllWithDepartureDateAfterFilter);;
        Map<String, Flight> filteredMapTask2 = filterService.filter(testData, findAllValidFilter);
        Map<String, Flight> filteredMapTask3 = filterService.filter(testData, findAllWithOnGroundDurationLessThanHoursFilter);

        System.out.println("\n\nTASK 1");
        printerService.printData(filteredMapTask1);
        System.out.println("\n\nTASK 2");
        printerService.printData(filteredMapTask2);
        System.out.println("\n\nTASK 3");
        printerService.printData(filteredMapTask3);
        System.out.println("\n");
    }
}
