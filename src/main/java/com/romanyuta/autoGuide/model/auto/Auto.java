package com.romanyuta.autoGuide.model.auto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Schema(description = "Сущность автомобиля")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Номер (регистрационный знак, например АА999А96)")
    private String number;
    @Schema(description = "Марка")
    private String brand;
    @Schema(description = "Цвет")
    private String color;
    @Schema(description = "Год выпуска")
    private LocalDate releaseDate;

    @Schema(description = "Время добавление записи")
    private LocalDateTime addingTime;

    public Auto() {
    }

    public Auto(String number, String brand, String color, LocalDate releaseDate) {
        this.number = number;
        this.brand = brand;
        this.color = color;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(LocalDateTime addingTime) {
        this.addingTime = addingTime;
    }
}
