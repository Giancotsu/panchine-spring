package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;
import com.giancotsu.panchine.model.Partita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartitaRepo extends JpaRepository<Partita, Long> {

    @Query("SELECT ic FROM Campionato c INNER JOIN Partita p ON (c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?2) INNER JOIN InCasa ic ON (ic.partita.idPartita = p.idPartita AND p.idPartita = ?1)" +
            "INNER JOIN Giocatore g ON g.idGiocatore = ic.giocatore.idGiocatore")
    List<InCasa> risultatiInCasaByCampionatoEPartita(Long idPartita, Long idCampionato);

    @Query("SELECT fc FROM Campionato c INNER JOIN Partita p ON (c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?2) INNER JOIN FuoriCasa fc ON (fc.partita.idPartita = p.idPartita AND p.idPartita = ?1)" +
            "INNER JOIN Giocatore g ON g.idGiocatore = fc.giocatore.idGiocatore")
    List<FuoriCasa> risultatiFuoriCasaByCampionatoEPartita(Long idPartita, Long idCampionato);

    @Query("SELECT COUNT(*) FROM Partita p WHERE p.campionato.idCampionato = ?1")
    Integer partiteCampionato(Long idCampionato);

    @Query("SELECT ic FROM InCasa ic INNER JOIN Partita p ON p.idPartita = ic.partita.idPartita AND p.idPartita = ?1")
    InCasa risultatiInCasaByIdPartita(Long idPartita);

    @Query("SELECT fc FROM FuoriCasa fc INNER JOIN Partita p ON p.idPartita = fc.partita.idPartita AND p.idPartita = ?1")
    FuoriCasa risultatiFuoriCasaByIdPartita(Long idPartita);

    @Query("SELECT p.idPartita FROM Campionato c INNER JOIN Partita p ON c.idCampionato = p.campionato.idCampionato AND c.idCampionato = ?1")
    List<Long> getIdPartiteCampionato(Long idCampionato);
}

/*
SELECT *
FROM partita
INNER JOIN campionato
ON partita.id_campionato = campionato.id_campionato AND campionato.id_campionato = 2
 */

