package com.demo.idesoft.configuration;

import com.demo.idesoft.client.HolidaysClient;
import com.demo.idesoft.model.Holiday;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class HolidayInitializer {

    private List<Holiday> holidays;
    private final HolidaysClient holidaysClient;

    public HolidayInitializer(HolidaysClient holidaysClient) {
        this.holidaysClient = holidaysClient;
    }

    @PostConstruct
    public void initialize() {
        holidays = holidaysClient.getHolidayData();
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }
}
