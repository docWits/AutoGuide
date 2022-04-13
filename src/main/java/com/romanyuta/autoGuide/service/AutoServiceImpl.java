package com.romanyuta.autoGuide.service;

import com.romanyuta.autoGuide.exception.ApiRequestException;
import com.romanyuta.autoGuide.model.Statistics;
import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoMapper;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.model.auto.dto.AutoResponse;
import com.romanyuta.autoGuide.repository.AutoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImpl implements AutoService {

    private static final Logger log = Logger.getLogger(AutoServiceImpl.class);

    private final AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }


    @Override
    public Auto findAutoById(Long id) {
        return autoRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable("users")
    public List<AutoResponse> findAllAuto(String field) {
        log.info("getting all auto");
        return autoRepository.findAll(Sort.by(Sort.Direction.ASC,field))
                .stream()
                .map(AutoMapper.INSTANSE::mapAutoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addAuto(AutoRequest autoRequest) {
        if (autoRequest != null){
            Auto auto = AutoMapper.INSTANSE.mapAuto(autoRequest);
            auto.setAddingTime(LocalDateTime.now());
            log.info("add new auto with number:" + autoRequest.getNumber());
            autoRepository.save(auto);
        }else{
            log.error("Неудачная попытка зарегистрировать пользователя");
            throw new ApiRequestException("cannot add new auto");
        }
    }

    @Override
    public void deleteAuto(Long id) {
        if (!autoRepository.existsById(id)){
            log.error("Невозможно удалить несуществующего пользователя");
            throw new ApiRequestException("auto with id=" + id + " does not exist");
        }else{
            log.info("Удален пользователь с id = "+id);
            autoRepository.deleteById(id);
        }
    }

    @Override
    public Statistics statBase() {
        Statistics statistics = new Statistics();
        statistics.setCount(autoRepository.count());
        statistics.setFirstAddingRecord(autoRepository.findFirstRecord());
        statistics.setLastAddingRecord(autoRepository.findLastRecord());
        statistics.setPopularBrand(autoRepository.mostPopularBrand());
        log.info("Вызов статистики по базе");
        return statistics;
    }
}
