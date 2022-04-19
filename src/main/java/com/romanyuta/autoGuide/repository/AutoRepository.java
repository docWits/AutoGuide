package com.romanyuta.autoGuide.repository;

import com.romanyuta.autoGuide.model.auto.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Long> {

    Auto findByBrand(String brand);

    @Query(value = "select adding_time from auto order by adding_time asc limit 1", nativeQuery=true)
    LocalDateTime findFirstRecord();

    @Query(value = "select adding_time from auto order by adding_time desc limit 1", nativeQuery=true)
    LocalDateTime findLastRecord();

    @Query(value = "select brand from auto group by brand order by count (*) desc limit 1", nativeQuery=true)
    String mostPopularBrand();
}
