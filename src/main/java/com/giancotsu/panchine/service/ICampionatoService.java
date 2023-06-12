package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Campionato;
import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;

import java.util.List;
import java.util.Optional;

public interface ICampionatoService {

    List<Campionato> getAll();

    Optional<Campionato> getById(Long id);

    Integer partiteGiocate(Long id);

    List<Long> partecipantiCampionato(Long id);

    List<InCasa> risultatiInCasa(Long idGiocatore, Long idCampionato);

    List<FuoriCasa> risultatiFuoriCasa(Long idGiocatore, Long idCampionato);

    Optional<Campionato> createCampionato(Campionato campionato);
}
