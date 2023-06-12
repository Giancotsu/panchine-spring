package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Giocatore;
import com.giancotsu.panchine.repository.IGiocatoreRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiocatoreService implements IGiocatoreService{

    private final IGiocatoreRepo giocatoreRepo;


    public GiocatoreService(IGiocatoreRepo giocatoreRepo) {
        this.giocatoreRepo = giocatoreRepo;

    }

    @Override
    public Optional<Giocatore> findById(Long id) {
        return giocatoreRepo.findById(id);
    }

    @Override
    public Optional<Giocatore> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Giocatore> findAll() {
        return (List<Giocatore>) giocatoreRepo.findAll();
    }

    @Override
    public Optional<Giocatore> createGiocatore(Giocatore giocatore) {
        giocatoreRepo.save(giocatore);
        return giocatoreRepo.findById(giocatore.getIdGiocatore());
    }

    @Override
    public Long numeroGiocatori() {
        return giocatoreRepo.count();
    }

    @Override
    public void eliminaGiocatore(Giocatore giocatore) {
        giocatoreRepo.delete(giocatore);
    }

    @Override
    public void eliminaGiocatoreById(Long id) {
        giocatoreRepo.deleteById(id);
    }

    @Override
    public Optional<Giocatore> modificaGiocatore(Giocatore giocatore) {
        giocatoreRepo.save(giocatore);
        return giocatoreRepo.findById(giocatore.getIdGiocatore());
    }
}
