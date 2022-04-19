package com.romanyuta.autoGuide.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoMutation implements GraphQLMutationResolver {

    private final AutoService autoService;

    @Autowired
    public AutoMutation(AutoService autoService) {
        this.autoService = autoService;
    }

    public void createAuto(AutoRequest autoRequest){
        autoService.addAuto(autoRequest);
    }

}
