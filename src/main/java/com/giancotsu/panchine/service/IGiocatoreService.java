package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Giocatore;

import java.util.List;
import java.util.Optional;

public interface IGiocatoreService {

    Optional<Giocatore> findById(Long id);
    Optional<Giocatore> findByName(String name);
    List<Giocatore> findAll();

    Optional<Giocatore> createGiocatore(Giocatore giocatore);

    Long numeroGiocatori();

    void eliminaGiocatore(Giocatore giocatore);

    void eliminaGiocatoreById(Long id);

    Optional<Giocatore> modificaGiocatore(Giocatore giocatore);
}
