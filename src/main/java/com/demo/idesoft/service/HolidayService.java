package com.demo.idesoft.service;

import com.demo.idesoft.client.HolidaysClient;
import com.demo.idesoft.configuration.HolidayInitializer;
import com.demo.idesoft.model.Holiday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class HolidayService {
    private static final Logger log = LoggerFactory.getLogger(HolidayService.class);

    private final HolidayInitializer holidayInitializer;

    public HolidayService(HolidayInitializer holidayInitializer) {
        this.holidayInitializer = holidayInitializer;
    }

    public List<Holiday> getHolidayData(List<Predicate<Holiday>> filters) {
        List<Holiday> holidays = holidayInitializer.getHolidays();

        // Aplicar los filtros opcionales si se proporcionan
        if (filters != null && !filters.isEmpty()) {
            holidays = holidays.stream()
                    .filter(holiday -> filters.stream().anyMatch(filter -> filter.test(holiday)))
                    .collect(Collectors.toList());
        }
        log.info("Cantidad de holidays: {}", holidays.size());
        return holidays;
    }
}
