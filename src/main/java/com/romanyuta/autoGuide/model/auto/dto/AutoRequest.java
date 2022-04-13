package com.romanyuta.autoGuide.model.auto.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class AutoRequest {
    private String number;
    private String brand;
    private String color;
    private LocalDate releaseDate;

    public AutoRequest(String number, String brand) {
        this.number = number;
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
