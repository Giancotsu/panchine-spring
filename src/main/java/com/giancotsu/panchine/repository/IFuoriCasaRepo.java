package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.FuoriCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuoriCasaRepo extends JpaRepository<FuoriCasa, Long> {
}
