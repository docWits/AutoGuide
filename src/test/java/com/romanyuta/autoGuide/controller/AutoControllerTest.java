package com.romanyuta.autoGuide.controller;

import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoResponse;
import com.romanyuta.autoGuide.repository.AutoRepository;
import com.romanyuta.autoGuide.service.AutoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.class)
public class AutoControllerTest {

    @InjectMocks
    AutoServiceImpl autoService;

    @Mock
    AutoRepository autoRepository;

    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    Auto RECORD_1 = new Auto("FF323E12","Opel","White", LocalDate.of(2004,10,14));
    Auto RECORD_2 = new Auto("GH123E41","Mazda","Red", LocalDate.of(2001,4,11));
    Auto RECORD_3 = new Auto("DV134S13","Opel","Green", LocalDate.of(2007,11,3));

    @Test
    public void findAllAuto_success() throws Exception{
        List<Auto> records = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2,RECORD_3));

        Mockito.when(this.autoRepository.findAll()).thenReturn(records);

        List<AutoResponse> autos = autoService.findAllAutoWithSort("number");
    }
}
