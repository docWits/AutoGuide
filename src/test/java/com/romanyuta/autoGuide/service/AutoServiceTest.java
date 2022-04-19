package com.romanyuta.autoGuide.service;

import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.repository.AutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutoServiceTest {

    private static final long ID = 1L;

    @Mock
    private AutoRepository autoRepository;

    @InjectMocks
    private AutoServiceImpl autoService;


    @Test
    void findAutoById_shouldCallRepository(){

    }

    @Test
    void addAuto_shouldCallRepository(){
        AutoRequest request = new AutoRequest();
        request.setBrand("test brand");

        when(autoRepository.save(any(Auto.class))).thenReturn(new Auto());
        autoService.addAuto(request);
        assertThat(autoRepository.findByBrand("test brand").getBrand()).isSameAs(request.getBrand());
    }
}
