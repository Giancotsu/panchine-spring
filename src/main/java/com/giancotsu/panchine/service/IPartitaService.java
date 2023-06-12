package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.*;

import java.util.List;
import java.util.Optional;

public interface IPartitaService {

    //SELECT

    List<Partita> findAll();

    Optional<Partita> findById(Long id);

    Partita findByTipoCompetizione(TipoCompetizione tipoCompetizione);

    Partita findByCampionato(Campionato campionato);

    Partita findByStadio(Stadio stadio);

    List<InCasa> risultatiInCasaByCampionatoEPartita(Long idPartita, Long idCampionato);

    List<FuoriCasa> risultatiFuoriCasaByCampionatoEPartita(Long idPartita, Long idCampionato);

    InCasa risultatiInCasaByIdPartita(Long idPartita);

    FuoriCasa risultatiFuoriCasaByIdPartita(Long idPartita);

    Integer partiteCampionato(Long idCampionato);

    List<Long> getIdPartiteCampionato(Long idCampionato);


    //CREATE

    Optional<Partita> createPartita(Partita partita);

    //UPDATE

    Optional<Partita> modificaPartita(Partita partita);

    //DELETE

    Boolean eliminaPartita(Partita partita);

    Boolean eliminaPartita(Long id);
}
