package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.FuoriCasa;

import java.util.List;
import java.util.Optional;

public interface IFuoriCasaService {

    //SELECT

    List<FuoriCasa> findAll();

    Optional<FuoriCasa> findById(Long id);

    //CREATE

    Optional<FuoriCasa> createFuoriCasa(FuoriCasa fuoriCasa);
}
