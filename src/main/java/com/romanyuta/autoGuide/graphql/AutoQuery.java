package com.romanyuta.autoGuide.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoResponse;
import com.romanyuta.autoGuide.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoQuery implements GraphQLQueryResolver {

    private final AutoService autoService;

    @Autowired
    public AutoQuery(AutoService autoService) {
        this.autoService = autoService;
    }

    public Auto getAuto(long id){
        return autoService.findAutoById(id);
    }
}
