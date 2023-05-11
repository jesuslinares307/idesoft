package com.demo.idesoft.client;

import com.demo.idesoft.dto.HolidayResponse;
import com.demo.idesoft.model.Holiday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class HolidaysClient {

    private final RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(HolidaysClient.class);

    public HolidaysClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Holiday> getHolidayData() {
        try {
            log.info("[getHolidayData]: IN");
            //TODO generar en el applications properties
            String url = "https://api.victorsanmartin.com/feriados/en.json";
            HolidayResponse holidayResponse = restTemplate.getForObject(url,HolidayResponse.class);

            log.info("Response: {}", holidayResponse.toString());

            // Obtener el cuerpo de la respuesta
            log.info("[getHolidayData]: OUT");
            return holidayResponse.getData();
        } catch (RestClientException e) {
            // Error al realizar la solicitud HTTP
            log.error("Error al realizar la solicitud HTTP: {}", e.getMessage());
            throw new RuntimeException("Error al realizar solicitud");
        }
    }
}
