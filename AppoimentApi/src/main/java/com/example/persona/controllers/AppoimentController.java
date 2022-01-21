package com.example.persona.controllers;

import com.example.persona.entities.Appoiment;
import com.example.persona.services.AppoimentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/appoiment")
public class AppoimentController extends BaseControllerImpl<Appoiment, AppoimentServiceImpl>{

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseControllerImpl.class);

    //Competable future testing 3 request
    @GetMapping("/hilo")
    public @ResponseBody ResponseEntity getAllCars() {
        try {
            CompletableFuture<List<Appoiment>> cars1=servicio.getAlll();
            CompletableFuture<List<Appoiment>> cars2=servicio.getAlll();
            CompletableFuture<List<Appoiment>> cars3=servicio.getAlll();
            CompletableFuture.allOf(cars1, cars2, cars3).join();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
