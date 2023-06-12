package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.Stadio;

import java.util.List;
import java.util.Optional;

public interface IStadioService {

    //SELECT

    List<Stadio> findAll();

    Optional<Stadio> findById(Long id);

    //CREATE

    Optional<Stadio> createStadio(Stadio stadio);
}
