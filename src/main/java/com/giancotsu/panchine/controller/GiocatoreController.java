package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.model.Giocatore;
import com.giancotsu.panchine.service.GiocatoreService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Log
@RestController
@CrossOrigin(origins="*" )
@RequestMapping("/api/giocatore")
public class GiocatoreController {

    private final GiocatoreService giocatoreService;

    public GiocatoreController(GiocatoreService giocatoreService) {
        this.giocatoreService = giocatoreService;
    }

    @GetMapping
    public List<Giocatore> findAll() {
        return giocatoreService.findAll();
    }

    @GetMapping("/{id}")
    public Giocatore getById(@PathVariable("id") Long id) throws Exception {

        if(giocatoreService.findById(id).isPresent()){
            return giocatoreService.findById(id).get();
        }

        throw new Exception("Giocatore non trovato");
    }

    @PostMapping(consumes = {"application/json"})
    public Giocatore saveGiocatore(@RequestBody Giocatore giocatore) {

        Giocatore giocatoreCreato;

        if(giocatore.getIdGiocatore() == null){
            giocatoreCreato = giocatoreService.createGiocatore(giocatore).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Giocatore esistente.");
        }

        return giocatoreCreato;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminaGiocatoreById(@PathVariable("id") Long id){
        giocatoreService.eliminaGiocatoreById(id);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public void eliminaGiocatore(@RequestBody Giocatore giocatore){
        giocatoreService.eliminaGiocatore(giocatore);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins="http://localhost:4200", methods = RequestMethod.PUT)
    public Giocatore modificaGiocatore(@Valid @RequestBody Giocatore giocatore){

        Giocatore giocatoreModificato;

        if(giocatore.getIdGiocatore() != null){
            giocatoreModificato = giocatoreService.modificaGiocatore(giocatore).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Giocatore inesistente.");
        }

        return giocatoreModificato;

    }

}
