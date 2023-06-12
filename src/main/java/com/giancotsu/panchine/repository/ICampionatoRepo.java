package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Campionato;
import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ICampionatoRepo extends JpaRepository<Campionato, Long> {

    @Query("SELECT COUNT(*) FROM Campionato c INNER JOIN Partita p ON p.campionato.idCampionato = c.idCampionato AND c.idCampionato = ?1")
    Integer partiteGiocate(Long id);


    @Query("SELECT DISTINCT g.idGiocatore FROM Campionato c INNER JOIN Partita p ON (c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?1)  INNER JOIN " +
            "InCasa ic ON ic.partita.idPartita = p.idPartita INNER JOIN Giocatore g ON g.idGiocatore = ic.giocatore.idGiocatore UNION " +
            "SELECT DISTINCT g.idGiocatore FROM Campionato c INNER JOIN Partita p ON(c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?1) INNER JOIN " +
            "FuoriCasa fc ON fc.partita.idPartita = p.idPartita INNER JOIN Giocatore g ON g.idGiocatore = fc.giocatore.idGiocatore")
    List<Long> partecipantiCampionato(Long id);

    @Query("SELECT ic FROM Campionato c INNER JOIN Partita p ON (c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?2) INNER JOIN InCasa ic ON ic.partita.idPartita = p.idPartita " +
            "INNER JOIN Giocatore g ON (g.idGiocatore = ic.giocatore.idGiocatore AND g.idGiocatore = ?1)")
    List<InCasa> risultatiInCasa(Long idGiocatore, Long idCampionato);

    @Query("SELECT fc FROM Campionato c INNER JOIN Partita p ON (c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?2) INNER JOIN FuoriCasa fc ON fc.partita.idPartita = p.idPartita " +
            "INNER JOIN Giocatore g ON (g.idGiocatore = fc.giocatore.idGiocatore AND g.idGiocatore = ?1)")
    List<FuoriCasa> risultatiFuoriCasa(Long idGiocatore, Long idCampionato);



}

