package com.romanyuta.autoGuide.service;

import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.repository.AutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        final Auto auto = mock(Auto.class);
        when(autoRepository.getById(ID)).thenReturn(auto);

        final Auto actual = autoService.findAutoById(ID);

        assertNotNull(actual);
        assertEquals(auto,actual);
        verify(autoRepository).getById(ID);
    }

    @Test
    void addAuto_shouldCallRepository(){
        final AutoRequest auto = mock(AutoRequest.class);
        final Auto auto1 = mock(Auto.class);

        autoService.addAuto(auto);

        verify(autoRepository).save(auto1);
    }
}
