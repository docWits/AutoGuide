package com.romanyuta.autoGuide.service;

import com.romanyuta.autoGuide.model.Statistics;
import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.model.auto.dto.AutoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoService {

    Auto findAutoById(Long id);
    List<AutoResponse> findAllAuto(String field);
    void addAuto(AutoRequest auto);
    void deleteAuto(Long id);
    Statistics statBase();
}
