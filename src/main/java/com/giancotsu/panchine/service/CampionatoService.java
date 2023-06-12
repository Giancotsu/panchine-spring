package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Campionato;
import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;
import com.giancotsu.panchine.repository.ICampionatoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CampionatoService implements ICampionatoService{

    private final ICampionatoRepo campionatoRepo;

    public CampionatoService(ICampionatoRepo campionatoRepo) {
        this.campionatoRepo = campionatoRepo;
    }

    @Override
    public List<Campionato> getAll() {
        return campionatoRepo.findAll();
    }

    @Override
    public Optional<Campionato> getById(Long id) {
        return campionatoRepo.findById(id);
    }

    @Override
    public Integer partiteGiocate(Long id) {
        return campionatoRepo.partiteGiocate(id);
    }

    @Override
    public List<Long> partecipantiCampionato(Long id) {
        return campionatoRepo.partecipantiCampionato(id);
    }

    @Override
    public List<InCasa> risultatiInCasa(Long idGiocatore, Long idCampionato) {
        return campionatoRepo.risultatiInCasa(idGiocatore, idCampionato);
    }

    @Override
    public List<FuoriCasa> risultatiFuoriCasa(Long idGiocatore, Long idCampionato) {
        return campionatoRepo.risultatiFuoriCasa(idGiocatore, idCampionato);
    }

    @Override
    public Optional<Campionato> createCampionato(Campionato campionato) {
        campionatoRepo.save(campionato);
        return getById(campionato.getIdCampionato());
    }
}
