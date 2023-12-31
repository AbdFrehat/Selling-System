package com.selling.system.reports.calc.price.controllers;

import com.selling.system.reports.calc.price.models.responses.CalcPriceResponse;
import com.selling.system.reports.calc.price.services.CalcPriceService;
import com.selling.system.shared.module.models.entities.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CalcPriceController {

    private final CalcPriceService calcPriceService;

    public CalcPriceController(CalcPriceService calcPriceService) {
        this.calcPriceService = calcPriceService;
    }

    @PostMapping
    public ResponseEntity<Mono<CalcPriceResponse>> getCalcPriceResponse(@RequestBody @Valid Flux<Item> items) {
        return new ResponseEntity<>(calcPriceService.buildCalcPriceResponse(items), HttpStatus.OK);
    }

}
