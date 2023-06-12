package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Stadio;
import com.giancotsu.panchine.repository.IStadioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadioService implements IStadioService{

    private final IStadioRepo stadioRepo;

    public StadioService(IStadioRepo stadioRepo) {
        this.stadioRepo = stadioRepo;
    }

    @Override
    public List<Stadio> findAll() {
        return stadioRepo.findAll();
    }

    @Override
    public Optional<Stadio> findById(Long id) {
        return stadioRepo.findById(id);
    }

    @Override
    public Optional<Stadio> createStadio(Stadio stadio) {
        stadioRepo.save(stadio);
        return findById(stadio.getIdStadio());
    }
}
