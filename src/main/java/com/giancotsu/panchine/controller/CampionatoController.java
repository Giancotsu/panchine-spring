package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.model.*;
import com.giancotsu.panchine.service.CampionatoService;
import com.giancotsu.panchine.service.ClassificaService;
import com.giancotsu.panchine.service.GiocatoreService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log
@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/api/campionato")
public class CampionatoController {

    private final CampionatoService campionatoService;
    private final GiocatoreService giocatoreService;
    private final ClassificaService classificaService;

    public CampionatoController(CampionatoService campionatoService, GiocatoreService giocatoreService, ClassificaService classificaService) {
        this.campionatoService = campionatoService;
        this.giocatoreService = giocatoreService;
        this.classificaService = classificaService;
    }

    @GetMapping
    public List<Campionato> findAll() {
        return campionatoService.getAll();
    }

    @GetMapping("/{id}")
    public Campionato getById(@PathVariable("id") Long id) throws Exception {

        if(campionatoService.getById(id).isPresent()){
            return campionatoService.getById(id).get();
        }
        throw new Exception("Campionato non trovato");
    }

    @GetMapping("partite-giocate/{id}")
    public Integer partiteGiocate(@PathVariable("id") Long id) throws Exception {

        if(campionatoService.getById(id).isPresent()){
            return campionatoService.partiteGiocate(id);
        }
        throw new Exception("Campionato non trovato");
    }

    @GetMapping("partecipanti/{id}")
    public List<Long> getPartecipanti(@PathVariable("id") Long id) throws Exception {

        if(campionatoService.getById(id).isPresent()){
            return campionatoService.partecipantiCampionato(id);
        }
        throw new Exception("Campionato non trovato");
    }

    @GetMapping("risultati-in-casa/{idGiocatore}/{idCampionato}")
    public List<InCasa> getRisultatiInCasa(@PathVariable("idGiocatore") Long idGiocatore, @PathVariable("idCampionato") Long idCampionato) throws Exception {

        if(campionatoService.getById(idCampionato).isPresent() && giocatoreService.findById(idGiocatore).isPresent()){
            return campionatoService.risultatiInCasa(idGiocatore, idCampionato);
        }
        throw new Exception("Campionato o giocatore non trovato");
    }

    @GetMapping("risultati-fuori-casa/{idGiocatore}/{idCampionato}")
    public List<FuoriCasa> getRisultatiFuoriCasa(@PathVariable("idGiocatore") Long idGiocatore, @PathVariable("idCampionato") Long idCampionato) throws Exception {

        if(campionatoService.getById(idCampionato).isPresent() && giocatoreService.findById(idGiocatore).isPresent()){
            return campionatoService.risultatiFuoriCasa(idGiocatore, idCampionato);
        }
        throw new Exception("Campionato o giocatore non trovato");
    }

    @GetMapping("classifica/{idCampionato}")
    public List<Classifica> getClassifica(@PathVariable("idCampionato") Long idCampionato) throws Exception {

        if(campionatoService.getById(idCampionato).isPresent()){
            return classificaService.calcoloPuntiClassifica(idCampionato);
        }
        throw new Exception("Campionato non trovato");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Campionato createCampionato(@RequestBody Campionato campionato) {

        Campionato nuovoCampionato;

        if(campionato.getIdCampionato() == null){
            nuovoCampionato = campionatoService.createCampionato(campionato).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Stadio esistente.");
        }

        return nuovoCampionato;
    }
}

























