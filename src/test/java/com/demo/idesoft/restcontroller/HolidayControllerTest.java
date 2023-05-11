package com.demo.idesoft.restcontroller;

import com.demo.idesoft.configuration.HolidayInitializer;
import com.demo.idesoft.model.Holiday;
import com.demo.idesoft.service.HolidayService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HolidayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HolidayInitializer holidayInitializer;

    @Test
    void getAllHolidays() throws Exception {
        when(holidayInitializer.getHolidays()).thenReturn(getMockAllHollidays());

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/holidays"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Religioso"))
                .andExpect(jsonPath("$[1].type").value("Civil"));
    }

    @Test
    void getAllHoliday_By_Type_Civil() throws Exception {
        when(holidayInitializer.getHolidays()).thenReturn(getMockAllHollidays());

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/holidays")
                                .param("type", "civil"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Civil"));
    }

    @Test
    void getAllHoliday_By_Type_Religioso() throws Exception {
        when(holidayInitializer.getHolidays()).thenReturn(getMockAllHollidays());

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/holidays")
                                .param("type", "religioso"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Religioso"));
    }

    @Test
    void getAllHoliday_with_wrong_type() throws Exception {
        when(holidayInitializer.getHolidays()).thenReturn(getMockAllHollidays());

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/holidays")
                                .param("type", "wrong"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    private List<Holiday> getMockAllHollidays() {
        List<Holiday> mockHolidays = new ArrayList<>();

        Holiday holiday1 = new Holiday();
        holiday1.setDate(LocalDate.parse("2023-04-07"));
        holiday1.setTitle("Viernes");
        holiday1.setType("Religioso");
        holiday1.setInalienable(false);
        holiday1.setExtra("Religioso");
        mockHolidays.add(holiday1);

        Holiday holiday2 = new Holiday();
        holiday2.setDate(LocalDate.parse("2023-01-02"));
        holiday2.setTitle("Feriado Adicional");
        holiday2.setType("Civil");
        holiday2.setInalienable(false);
        holiday2.setExtra("Civil");
        mockHolidays.add(holiday2);
        return mockHolidays;
    }
}