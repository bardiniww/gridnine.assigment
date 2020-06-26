package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public interface Filter {

    Map<String, Flight> doFilter(Map<String, Flight> flights);

    default Map<String, Flight> findAllByYear(Map<String, Flight> flights, int year) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().getYear() == year) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllByMonth(Map<String, Flight> flights, Month month) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().getMonth().equals(month)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllByDate(Map<String, Flight> flights, LocalDate date) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().toLocalDate().isEqual(date)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllByFromDateToDate(Map<String, Flight> flights, LocalDate fromDate, LocalDate toDate) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().toLocalDate().isAfter(fromDate) && value.getDepartureDate().toLocalDate().isBefore(toDate)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllValid(Map<String, Flight> flights) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.isValid()) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllInvalid(Map<String, Flight> flights) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (!value.isValid()) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithSegmentCountLessThan(Map<String, Flight> flights, int count) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSegmentCount() < count) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithSegmentCountGreaterThan(Map<String, Flight> flights, int count) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSegmentCount() > count) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithSegmentCountEquals(Map<String, Flight> flights, int count) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSegmentCount() == count) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithDepartureDateBefore(Map<String, Flight> flights, LocalDateTime date) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().isBefore(date)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithDepartureDateAfter(Map<String, Flight> flights, LocalDateTime date) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getDepartureDate().isAfter(date)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithArrivalDateBefore(Map<String, Flight> flights, LocalDateTime date) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getArrivalDate().isBefore(date)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithArrivalDateAfter(Map<String, Flight> flights, LocalDateTime date) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getArrivalDate().isAfter(date)) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationLessThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() < seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationLessThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() < minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationLessThanHours(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() < hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationGreaterThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() > seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationGreaterThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() > minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithTotalDurationGreaterThan(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getTotalFlightDuration() > hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationLessThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() < seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationLessThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() < minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationLessThanHours(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() < hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationGreaterThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() > seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationGreaterThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() > minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithInFlightDurationGreaterThanHours(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsInFLight() > hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationLessThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() < seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationLessThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() < minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationLessThanHours(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() < hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationGreaterThanSeconds(Map<String, Flight> flights, int seconds) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() > seconds) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationGreaterThanMinutes(Map<String, Flight> flights, int minutes) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() > minutes * 60) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }

    default Map<String, Flight> findAllWithOnGroundDurationGreaterThanHours(Map<String, Flight> flights, int hours) {
        Map<String, Flight> resultMap = new HashMap<>();

        flights.forEach((key, value) -> {
            if (value.getSecondsOnGround() > hours * 3600) {
                resultMap.put(key, value);
            }
        });

        return resultMap;
    }
}
