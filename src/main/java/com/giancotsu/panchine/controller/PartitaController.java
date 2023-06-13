package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;
import com.giancotsu.panchine.model.Partita;
import com.giancotsu.panchine.service.*;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log
@CrossOrigin(origins="*" )
@RestController
@RequestMapping("/api/partita")
public class PartitaController {

    private final PartitaService partitaService;
    private final CampionatoService campionatoService;
    private final InCasaService inCasaService;
    private final FuoriCasaService fuoriCasaService;

    public PartitaController(PartitaService partitaService, CampionatoService campionatoService, GiocatoreService giocatoreService, InCasaService inCasaService, FuoriCasaService fuoriCasaService) {
        this.partitaService = partitaService;
        this.campionatoService = campionatoService;
        this.inCasaService = inCasaService;
        this.fuoriCasaService = fuoriCasaService;
    }

    @GetMapping("/{id}")
    public Partita getById(@PathVariable("id") Long id){
        return partitaService.findById(id).get();
    }

    @GetMapping
    public List<Partita> getAll(){
        return partitaService.findAll();
    }

    @GetMapping("risultati-in-casa-partita-campionato/{idPartita}/{idCampionato}")
    public List<InCasa> getRisultatiInCasaCampionato(@PathVariable("idPartita") Long idPartita, @PathVariable("idCampionato") Long idCampionato) throws Exception {

        if(campionatoService.getById(idCampionato).isPresent() && partitaService.findById(idPartita).isPresent()){
            return partitaService.risultatiInCasaByCampionatoEPartita(idPartita, idCampionato);
        }
        throw new Exception("Campionato o partita non trovata");
    }

    @GetMapping("risultati-fuori-casa-partita-campionato/{idPartita}/{idCampionato}")
    public List<FuoriCasa> getRisultatiFuoriCasaCampionato(@PathVariable("idPartita") Long idPartita, @PathVariable("idCampionato") Long idCampionato) throws Exception {

        if(campionatoService.getById(idCampionato).isPresent() && partitaService.findById(idPartita).isPresent()){
            return partitaService.risultatiFuoriCasaByCampionatoEPartita(idPartita, idCampionato);
        }
        throw new Exception("Campionato o partita non trovata");
    }

    @GetMapping("risultati-in-casa-partita/{idPartita}")
    public InCasa getRisultatiInCasaPartita(@PathVariable("idPartita") Long idPartita) throws Exception {

        if(partitaService.findById(idPartita).isPresent()){
            return partitaService.risultatiInCasaByIdPartita(idPartita);
        }
        throw new Exception("Partita non trovata");
    }

    @GetMapping("risultati-fuori-casa-partita/{idPartita}")
    public FuoriCasa getRisultatiFuoriCasaPartita(@PathVariable("idPartita") Long idPartita) throws Exception {

        if(partitaService.findById(idPartita).isPresent()){
            return partitaService.risultatiFuoriCasaByIdPartita(idPartita);
        }
        throw new Exception("Partita non trovata");
    }

    @GetMapping("num-partite-campionato/{idCampionato}")
    public Integer getNumPartiteCampionato(@PathVariable("idCampionato") Long idCampionato){
        return partitaService.partiteCampionato(idCampionato);
    }

    @GetMapping("partite-campionato/{idCampionato}")
    public List<Long> getIdPartiteCampionato(@PathVariable("idCampionato") Long idCampionato){
        return partitaService.getIdPartiteCampionato(idCampionato);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Partita createPartita(@RequestBody Partita partita) {

        Partita partitaCreata;

        if(partita.getIdPartita() == null){
            partitaCreata = partitaService.createPartita(partita).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Partita esistente.");
        }

        return partitaCreata;
    }


    //InCasa e FuoriCasa

    @GetMapping("partite-in-casa")
    public List<InCasa> getAllInCasa(){
        return inCasaService.findAll();
    }

    @GetMapping("partite-fuori-casa")
    public List<FuoriCasa> getAllFuoriCasa(){
        return fuoriCasaService.findAll();
    }

    @PostMapping(value = "nuova-in-casa", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InCasa createPartitaInCasa(@RequestBody InCasa inCasa) {

        InCasa nuovaPartitaInCasa;

        if(inCasa.getIdInCasa() == null){
            nuovaPartitaInCasa = inCasaService.createInCasa(inCasa).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Partita in casa esistente.");
        }

        return nuovaPartitaInCasa;
    }

    @PostMapping(value = "nuova-fuori-casa", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FuoriCasa createPartitaFuoriCasa(@RequestBody FuoriCasa fuoriCasa) {

        FuoriCasa nuovaPartitaFuoriCasa;

        if(fuoriCasa.getIdFuoriCasa() == null){
            nuovaPartitaFuoriCasa = fuoriCasaService.createFuoriCasa(fuoriCasa).get();
        }else{
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Partita fuori casa esistente.");
        }

        return nuovaPartitaFuoriCasa;
    }


}
























