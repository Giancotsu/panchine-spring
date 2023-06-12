package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.FuoriCasa;
import com.giancotsu.panchine.model.InCasa;
import com.giancotsu.panchine.repository.IFuoriCasaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuoriCasaService implements IFuoriCasaService{

    private final IFuoriCasaRepo fuoriCasaRepo;

    public FuoriCasaService(IFuoriCasaRepo fuoriCasaRepo) {
        this.fuoriCasaRepo = fuoriCasaRepo;
    }


    @Override
    public List<FuoriCasa> findAll() {
        return fuoriCasaRepo.findAll();
    }

    @Override
    public Optional<FuoriCasa> findById(Long id) {
        return fuoriCasaRepo.findById(id);
    }

    @Override
    public Optional<FuoriCasa> createFuoriCasa(FuoriCasa fuoriCasa) {
        fuoriCasaRepo.save(fuoriCasa);
        return findById(fuoriCasa.getIdFuoriCasa());
    }
}
