package com.demo.idesoft.restcontroller;

import com.demo.idesoft.model.Holiday;
import com.demo.idesoft.service.HolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class HolidayController {

    private static final Logger log = LoggerFactory.getLogger(HolidayController.class);


    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping(path = "/holidays")

    public ResponseEntity<?> getHolidays(@RequestParam(value = "type", required = false) String type) {
        log.info("Obteniendo holidays con type: {}", type);

        //TODO: colocar los type en enum
        List<Predicate<Holiday>> filters = new ArrayList<>();

        if (type != null && !type.isEmpty()) {
            filters.add(holiday -> holiday.getType().equalsIgnoreCase(type));
        }
        log.info("Cantidad de holidays filtradas: {}", filters.size());
        return new ResponseEntity<>(holidayService.getHolidayData(filters), HttpStatus.OK);
    }
}
