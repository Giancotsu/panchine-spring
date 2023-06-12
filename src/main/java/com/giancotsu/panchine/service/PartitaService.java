package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.*;
import com.giancotsu.panchine.repository.IPartitaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartitaService implements IPartitaService{

    private final IPartitaRepo partitaRepo;

    public PartitaService(IPartitaRepo partitaRepo) {
        this.partitaRepo = partitaRepo;
    }

    @Override
    public List<Partita> findAll() {
        return partitaRepo.findAll();
    }

    @Override
    public Optional<Partita> findById(Long id) {
        return partitaRepo.findById(id);
    }

    @Override
    public Partita findByTipoCompetizione(TipoCompetizione tipoCompetizione) {
        return null;
    }

    @Override
    public Partita findByCampionato(Campionato campionato) {
        return null;
    }

    @Override
    public Partita findByStadio(Stadio stadio) {
        return null;
    }

    @Override
    public List<InCasa> risultatiInCasaByCampionatoEPartita(Long idPartita, Long idCampionato) {
        return partitaRepo.risultatiInCasaByCampionatoEPartita(idPartita, idCampionato);
    }

    @Override
    public List<FuoriCasa> risultatiFuoriCasaByCampionatoEPartita(Long idPartita, Long idCampionato) {
        return partitaRepo.risultatiFuoriCasaByCampionatoEPartita(idPartita, idCampionato);
    }

    @Override
    public InCasa risultatiInCasaByIdPartita(Long idPartita) {
        return partitaRepo.risultatiInCasaByIdPartita(idPartita);
    }

    @Override
    public FuoriCasa risultatiFuoriCasaByIdPartita(Long idPartita) {
        return partitaRepo.risultatiFuoriCasaByIdPartita(idPartita);
    }

    @Override
    public Integer partiteCampionato(Long idCampionato) {
        return partitaRepo.partiteCampionato(idCampionato);
    }

    @Override
    public Optional<Partita> createPartita(Partita partita) {
        partitaRepo.save(partita);
        return findById(partita.getIdPartita());
    }

    @Override
    public List<Long> getIdPartiteCampionato(Long idCampionato){
        return partitaRepo.getIdPartiteCampionato(idCampionato);
    }

    @Override
    public Optional<Partita> modificaPartita(Partita partita) {
        return Optional.empty();
    }

    @Override
    public Boolean eliminaPartita(Partita partita) {
        return null;
    }

    @Override
    public Boolean eliminaPartita(Long id) {
        return null;
    }
}
