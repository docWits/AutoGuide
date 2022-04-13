package com.romanyuta.autoGuide.model.auto.dto;

import com.romanyuta.autoGuide.model.auto.Auto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {
    AutoMapper INSTANSE = Mappers.getMapper(AutoMapper.class);
    AutoResponse mapAutoToDto(Auto auto);
    Auto mapAuto (AutoRequest autoRequest);
}
