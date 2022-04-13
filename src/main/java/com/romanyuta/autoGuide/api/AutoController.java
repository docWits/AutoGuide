package com.romanyuta.autoGuide.api;

import com.romanyuta.autoGuide.model.Statistics;
import com.romanyuta.autoGuide.model.auto.Auto;
import com.romanyuta.autoGuide.model.auto.dto.AutoRequest;
import com.romanyuta.autoGuide.model.auto.dto.AutoResponse;
import com.romanyuta.autoGuide.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/auto")
@Tag(name = "Автомобили", description = "API для взаимодействия с автомобилями ")
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @Operation(
            summary = "Список всех автомобилей",
            description = "Позволяет посмотреть список всех автомобилей"
    )
    @GetMapping(value = "/{field}",produces = APPLICATION_JSON_VALUE)
    public List<AutoResponse> findAllAutos(@PathVariable @Parameter(description = "Параметр для сортировки") String field){
        return autoService.findAllAuto(field);
    }

    @Operation(
            summary = "Добавление автомобиля",
            description = "Позволяет зарегистрировать авто"
    )
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoRequest> addAuto(@RequestBody AutoRequest autoRequest){
        autoService.addAuto(autoRequest);
        return ResponseEntity.ok(autoRequest);
    }

    @Operation(
            summary = "Удаление автомобиля",
            description = "Позволяет удалить автомобиль по id"
    )
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteAuto(@PathVariable @Parameter(description = "Идентификатор") Long id){
        autoService.deleteAuto(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @Operation(
            summary = "Статистика базы",
            description = "Позволяет просмотреть статистику по базе"
    )
    @GetMapping(value = "/stat", produces = APPLICATION_JSON_VALUE)
    public Statistics statBase(){
        return autoService.statBase();
    }
}
