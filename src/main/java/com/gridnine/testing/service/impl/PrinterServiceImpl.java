package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.PrinterService;

import java.util.Map;

public class PrinterServiceImpl implements PrinterService {

    @Override
    public void printData(Map<String, Flight> data) {
        System.out.println("===================================================================================================================================");

        for(Map.Entry<String, Flight> flight : data.entrySet()) {
            System.out.println("FLIGHT ID: [" + flight.getKey() + "]  SEGMENTS:" + flight.getValue());
        }

        System.out.println("===================================================================================================================================");
    }
}
