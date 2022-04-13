package com.romanyuta.autoGuide.model;

import java.time.LocalDateTime;

public class Statistics {

    Long count;
    LocalDateTime firstAddingRecord;
    LocalDateTime lastAddingRecord;
    String popularBrand;


    public Statistics() {
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getFirstAddingRecord() {
        return firstAddingRecord;
    }

    public void setFirstAddingRecord(LocalDateTime firstAddingRecord) {
        this.firstAddingRecord = firstAddingRecord;
    }

    public LocalDateTime getLastAddingRecord() {
        return lastAddingRecord;
    }

    public void setLastAddingRecord(LocalDateTime lastAddingRecord) {
        this.lastAddingRecord = lastAddingRecord;
    }

    public String getPopularBrand() {
        return popularBrand;
    }

    public void setPopularBrand(String popularBrand) {
        this.popularBrand = popularBrand;
    }
}
