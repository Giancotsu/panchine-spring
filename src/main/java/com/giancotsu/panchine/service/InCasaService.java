package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.InCasa;
import com.giancotsu.panchine.repository.IInCasaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InCasaService implements IInCasaService{

    private final IInCasaRepo inCasaRepo;

    public InCasaService(IInCasaRepo inCasaRepo) {
        this.inCasaRepo = inCasaRepo;
    }

    @Override
    public List<InCasa> findAll() {
        return inCasaRepo.findAll();
    }

    @Override
    public Optional<InCasa> findById(Long id) {
        return inCasaRepo.findById(id);
    }

    @Override
    public Optional<InCasa> createInCasa(InCasa inCasa) {
        inCasaRepo.save(inCasa);
        return findById(inCasa.getIdInCasa());
    }
}
