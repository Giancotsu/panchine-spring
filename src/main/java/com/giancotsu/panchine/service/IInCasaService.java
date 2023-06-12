package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.InCasa;

import java.util.List;
import java.util.Optional;

public interface IInCasaService {

    //SELECT

    List<InCasa> findAll();

    Optional<InCasa> findById(Long id);

    //CREATE

    Optional<InCasa> createInCasa(InCasa inCasa);
}
