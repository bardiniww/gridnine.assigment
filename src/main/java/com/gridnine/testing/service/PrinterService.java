package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.Map;

public interface PrinterService {
    void printData(Map<String, Flight> data);
}
