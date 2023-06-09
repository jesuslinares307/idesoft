package com.demo.idesoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Holiday {
    private LocalDate date;
    private String title;
    private String type;
    private Boolean inalienable;
    private String extra;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getInalienable() {
        return inalienable;
    }

    public void setInalienable(Boolean inalienable) {
        this.inalienable = inalienable;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", inalienable=" + inalienable +
                ", extra='" + extra + '\'' +
                '}';
    }
}
