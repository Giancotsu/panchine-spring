package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.model.Partita;
import com.giancotsu.panchine.model.Stadio;
import com.giancotsu.panchine.service.StadioService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log
@RestController
@CrossOrigin(origins="*" )
@RequestMapping("/api/stadio")
public class StadioController {

    private final StadioService stadioService;

    public StadioController(StadioService stadioService) {
        this.stadioService = stadioService;
    }

    @GetMapping
    public List<Stadio> findAll() {
        return stadioService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stadio createStadio(@RequestBody Stadio stadio) {

        Stadio nuovoStadio;

        if(stadio.getIdStadio() == null){
            nuovoStadio = stadioService.createStadio(stadio).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Stadio esistente.");
        }

        return nuovoStadio;
    }
}
