package com.demo.idesoft.dto;


import com.demo.idesoft.model.Holiday;

import java.util.List;

public class HolidayResponse {
    private String status;
    private List<Holiday> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Holiday> getData() {
        return data;
    }

    public void setData(List<Holiday> data) {
        this.data = data;
    }
}
